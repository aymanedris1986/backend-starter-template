package com.ed.core.controller.base;

import com.ed.core.dto.base.ApiResponse;
import com.ed.core.service.base.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public abstract class CrudController<O,I,D> extends AppController {
    protected abstract CrudService<O,I,D> getCrudService();

    public ResponseEntity<ApiResponse<List<D>>> getAll(
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return generateSuccessResponse(getCrudService().getAll(pageable));
    }

    public ResponseEntity<ApiResponse<Long>> getAllCount() {
        return generateSuccessResponse(getCrudService().getAllCount());
    }

    public ResponseEntity<ApiResponse<D>> findById(I id) {
        return generateSuccessResponse(getCrudService().getById(id));
    }

    public ResponseEntity<ApiResponse<D>> update(D dto) {
        return generateSuccessResponse(getCrudService().update(dto));
    }

    public ResponseEntity<ApiResponse<D>> insert(D dto) {
        return generateSuccessResponse(getCrudService().insert(dto));
    }


}
