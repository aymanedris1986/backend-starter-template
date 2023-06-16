package com.ed.core.controller;

import com.ed.core.dto.LookupDTO;
import com.ed.core.dto.LookupEditableDto;
import com.ed.core.entity.Lookup;
import com.ed.core.service.LookupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import com.ed.core.controller.base.CrudController;
import com.ed.core.dto.base.ApiResponse;
import com.ed.core.service.base.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class LookupController extends CrudController<Lookup,Long, LookupEditableDto>{
        public static final String CONTROLLER_PATH = "/lookup";
            public final LookupService lookupService;

            @Override
            protected CrudService<Lookup, Long, LookupEditableDto> getCrudService() {
                return  lookupService;
            }

            @Override
            @GetMapping(CONTROLLER_PATH)
            public ResponseEntity<ApiResponse<List<LookupEditableDto>>> getAll(
                    @RequestParam(defaultValue = "0") int page,
                    @RequestParam(defaultValue = "10") int size) {
                return super.getAll(page, size);
            }

            @Override
            @GetMapping(CONTROLLER_PATH+"/count")
            public ResponseEntity<ApiResponse<Long>> getAllCount() {
                return super.getAllCount();
            }

            @Override
            @GetMapping(CONTROLLER_PATH + "/{id}")
            public ResponseEntity<ApiResponse<LookupEditableDto>> findById(@PathVariable("id") Long id) {
                return super.findById(id);
            }

            @Override
            @PutMapping(CONTROLLER_PATH)
            public ResponseEntity<ApiResponse<LookupEditableDto>> update(@RequestBody LookupEditableDto dto) {
                return super.update(dto);
            }

            @Override
            @PostMapping(CONTROLLER_PATH)
            public ResponseEntity<ApiResponse<LookupEditableDto>> insert(@RequestBody LookupEditableDto dto) {
                return super.insert(dto);
            }
}
