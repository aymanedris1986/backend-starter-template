package com.ed.core.controller;

import com.ed.core.controller.base.CrudController;
import com.ed.core.dto.RegionDto;
import com.ed.core.dto.base.ApiResponse;
import com.ed.core.entity.Region;
import com.ed.core.service.RegionService;
import com.ed.core.service.base.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RegionController extends CrudController<Region, Long, RegionDto> {
    public static final String CONTROLLER_PATH = "/region";
    public final RegionService regionService;

    @Override
    protected CrudService<Region, Long, RegionDto> getCrudService() {
        return regionService;
    }

    @Override
    @GetMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<List<RegionDto>>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return super.getAll(page, size);
    }

    @Override
    @GetMapping(CONTROLLER_PATH + "/count")
    public ResponseEntity<ApiResponse<Long>> getAllCount() {
        return super.getAllCount();
    }

    @Override
    @GetMapping(CONTROLLER_PATH + "/{id}")
    public ResponseEntity<ApiResponse<RegionDto>> findById(@PathVariable("id") Long id) {
        return super.findById(id);
    }

    @Override
    @PutMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<RegionDto>> update(@RequestBody RegionDto dto) {
        return super.update(dto);
    }

    @Override
    @PostMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<RegionDto>> insert(@RequestBody RegionDto dto) {
        return super.insert(dto);
    }
}
