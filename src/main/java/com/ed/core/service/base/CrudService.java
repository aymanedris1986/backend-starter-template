package com.ed.core.service.base;

import com.ed.core.exception.ApplicationErrors;
import com.ed.core.dto.exception.ValidationErrorsDTO;
import com.ed.core.exception.ServiceException;
import com.ed.core.exception.ValidationException;
import com.ed.core.utils.Utils;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public abstract class CrudService<O, I, D> extends AppService {


    public List<D> getAll() {
        List<O> modelObject = getRepository().findAll();
        return mapList(modelObject);
    }



    public List<D> getAll(Pageable pageable) {
        Page<O> modelObjectPage = getRepository().findAll(pageable);
        List<O> modelObject = modelObjectPage.getContent();
        return mapList(modelObject);
    }

    public long getAllCount() {
        return getRepository().count();
    }

    public D getById(I id) {
        Optional<O> byId = getRepository().findById(id);
        return mapFromModelToDto(byId.get());
    }

    protected D mapFromModelToDto(O o) {
        return getModelMapper().map(o,getDtoClassType());
    }

    public void validateModel(O model) {
        ValidationErrorsDTO vd = new ValidationErrorsDTO();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<O>> violations = validator.validate(model);
        if (!violations.isEmpty()) {
            violations.stream().forEach(projectConstraintViolation -> {
                vd.addError("V0001", projectConstraintViolation.getPropertyPath().toString() + " : " + projectConstraintViolation.getMessage());
            });
        }
        if (vd.hasErrors()) {
            throw new ValidationException(vd);
        }
    }

    public void delete(I id) throws ServiceException {
        O byId = getRepository().findById(id).get();
        getRepository().delete(byId);
    }


    public D insert(D dto) {
        if (!Utils.isNullOrEmpty(getDtoId(dto))) {
            try {
                getRepository().findById(getDtoId(dto)).get();
                ValidationException validationException = new ValidationException();
                validationException.setValidationErrorsDTO(new ValidationErrorsDTO(ApplicationErrors.RECORD_ALREADY_EXISTS.getKey(), ApplicationErrors.RECORD_ALREADY_EXISTS.getValue()));
                throw validationException;
            } catch (NoSuchElementException e) {
                log.info(e.getMessage());
            }
        }
        O model = getNewModelObject();
        mapLovs(dto, model);
        mapFromDtoToModel(dto, model);
        validateModel(model);
        model = preInsert(model,dto);
        model = getRepository().save(model);
        D afterDto = (D) mapFromModelToDto(model);
        afterDto = afterInsert(model,afterDto);
        return afterDto;
    }

    protected void mapFromDtoToModel(D dto, O model) {
        BeanUtils.copyProperties(dto, model);
    }

    protected O preInsert(O model,D dto) {
        return model;
    }

    protected D afterInsert(O model,D dto) {
        return dto;
    }

    public D update(D dto) {
        O model = getRepository().findById(getDtoId(dto)).get();
        mapLovs(dto, model);
        mapFromDtoToModel(dto, model);
        validateModel(model);
        model = preUpdate(model,dto);
        model = getRepository().save(model);
        D afterDto = (D) mapFromModelToDto(model);
        afterDto = afterInsert(model,afterDto);
        return afterDto;
    }

    protected O preUpdate(O model,D dto) {
        return model;
    }

    protected D afterUpdate(O model,D dto) {
        return dto;
    }

    protected List<D> mapList(List<O> modelObject) {
        return modelObject.stream()
                .map(obj -> mapFromModelToDto(obj))
                .collect(Collectors.toList());
    }

    protected abstract JpaRepository<O, I> getRepository();

    protected abstract Class<O> getModelClassType();

    protected abstract Class<D> getDtoClassType();

    protected abstract I getDtoId(D dto);

    protected abstract O getNewModelObject();

    protected abstract void mapLovs(D src, O dest);
}
