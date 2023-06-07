package com.ed.core.controller.base;

import com.ed.core.dto.base.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/api")
public abstract class AppController {

    public static final String SUCCESS = "success";

    public <T> ResponseEntity<ApiResponse<T>> generateSuccessResponse(T response){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, SUCCESS,response));
    }
}
