package com.ed.core.service;

import com.ed.core.dto.LookupEditableDto;
import com.ed.core.entity.Lookup;
import com.ed.core.repository.LookupRepository;
import com.ed.core.service.base.AuditCrudService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LookupService extends AuditCrudService<Lookup,Long, LookupEditableDto> {

    private final LookupRepository lookupRepository;

    @Override
    protected JpaRepository<Lookup, Long> getRepository() {
        return lookupRepository;
    }

    @Override
    protected Class<Lookup> getModelClassType() {
        return Lookup.class;
    }

    @Override
    protected Class<LookupEditableDto> getDtoClassType() {
        return LookupEditableDto.class;
    }

    @Override
    protected Long getDtoId(LookupEditableDto dto) {
        return dto.getId();
    }

    @Override
    protected Lookup getNewModelObject() {
        return new Lookup();
    }

    @Override
    protected LookupEditableDto mapFromModelToDto(Lookup o) {
        LookupEditableDto dto = new LookupEditableDto();
        dto.setId(o.getLookupSeq());
        dto.setCode(o.getId());
        dto.setName(o.getName());
        dto.setLookupType(o.getLookupType());
        dto.setCreatedBy(o.getCreatedBy());
        dto.setDescriptionAr(o.getDescriptionAr());
        dto.setCreatedAt(o.getCreatedAt());
        dto.setUpdatedAt(o.getUpdatedAt());
        dto.setUpdatedBy(o.getUpdatedBy());
        return dto;
    }

    @Override
    protected void mapFromDtoToModel(LookupEditableDto dto, Lookup model) {
        if(isValueUpdated(dto.getCode(),model.getId())){
            model.setId(dto.getCode());
        }
        if (isValueUpdated(dto.getId(),model.getLookupSeq())) {
            model.setLookupSeq(dto.getId());
        }
        if(isValueUpdated(dto.getName(),model.getName())){
            model.setName(dto.getName());
        }
        if(isValueUpdated(dto.getLookupType(),model.getLookupType())){
            model.setLookupType(dto.getLookupType());
        }
        if(isValueUpdated(dto.getCreatedBy(),model.getCreatedBy())){
            model.setCreatedBy(dto.getCreatedBy());
        }
        if(isValueUpdated(dto.getDescriptionAr(),model.getDescriptionAr())){
            model.setDescriptionAr(dto.getDescriptionAr());
        }
        if(isValueUpdated(dto.getCreatedAt(),model.getCreatedAt())){
            model.setCreatedAt(dto.getCreatedAt());
        }
        if(isValueUpdated(dto.getUpdatedAt(),model.getUpdatedAt())){
            model.setUpdatedAt(dto.getUpdatedAt());
        }
        if(isValueUpdated(dto.getUpdatedBy(),model.getUpdatedBy())){
            model.setUpdatedBy(dto.getUpdatedBy());
        }
    }





    @Override
    protected void mapLovs(LookupEditableDto src, Lookup dest) {

    }
}
