package com.ed.core.controller.base;

import com.ed.core.dto.base.ApiResponse;
import com.ed.core.service.security.AppUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/v1/api")
public abstract class AppController {

    public static final String SUCCESS = "success";
    @Autowired
    @Getter
    private AppUserDetailsService userDetails;

    public <T> ResponseEntity<ApiResponse<T>> generateSuccessResponse(T response){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, SUCCESS,response));
    }


}
