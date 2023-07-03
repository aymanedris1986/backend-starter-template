package com.ed.core.controller;

import com.ed.core.controller.base.CrudController;
import com.ed.core.dto.SecUserProfileDto;
import com.ed.core.dto.base.ApiResponse;
import com.ed.core.entity.SecUser;
import com.ed.core.service.SecUserProfileService;
import com.ed.core.service.base.CrudService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class SecUserProfileController extends CrudController<SecUser, String, SecUserProfileDto> {

    public static final String CONTROLLER_PATH = "/user-profile";

    public final SecUserProfileService secUserProfileService;

    @Override
    protected CrudService<SecUser, String, SecUserProfileDto> getCrudService() {
        return secUserProfileService;
    }

    @Override
    @GetMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<List<SecUserProfileDto>>> getAll(
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
    public ResponseEntity<ApiResponse<SecUserProfileDto>> findById(@PathVariable("id") String id) {
        return super.findById(id);
    }

    @Override
    @PutMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<SecUserProfileDto>> update(@RequestBody SecUserProfileDto dto) {
        return super.update(dto);
    }

    @Override
    @PostMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<SecUserProfileDto>> insert(@RequestBody SecUserProfileDto dto) {
        return super.insert(dto);
    }
}
