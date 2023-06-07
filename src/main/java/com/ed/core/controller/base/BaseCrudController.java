package com.ed.core.controller.base;

import com.ed.core.dto.base.BaseApiResponse;
import com.ed.core.service.base.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public abstract class BaseCrudController<O,I,D> extends BaseController{
    protected abstract CrudService<O,I,D> getCrudService();

    public ResponseEntity<BaseApiResponse<List<D>>> getAll(
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return generateSuccessResponse(getCrudService().getAll(pageable));
    }

    public ResponseEntity<BaseApiResponse<Long>> getAllCount() {
        return generateSuccessResponse(getCrudService().getAllCount());
    }

    public ResponseEntity<BaseApiResponse<D>> findById(I id) {
        return generateSuccessResponse(getCrudService().getById(id));
    }

    public ResponseEntity<BaseApiResponse<D>> update(D dto) {
        return generateSuccessResponse(getCrudService().update(dto));
    }

    public ResponseEntity<BaseApiResponse<D>> insert(D dto) {
        return generateSuccessResponse(getCrudService().insert(dto));
    }


}
