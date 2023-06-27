package com.ed.core.exception;

import com.ed.core.dto.base.ApiResponse;
import com.ed.core.dto.exception.ApiErrorDTO;
import com.ed.core.dto.exception.ValidationErrorsDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({ValidationException.class})
    public ResponseEntity<ApiResponse<ValidationErrorsDTO>> handleOtherExceptions(ValidationException e , HttpServletRequest request) {
        e.printStackTrace();
        log.info(e.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(HttpStatus.BAD_REQUEST,ErrorTypes.VALIDATION_ERROR.toString(),e.getValidationErrorsDTO()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({ApiError.class})
    public ResponseEntity<ApiResponse<ApiErrorDTO>> handleOtherExceptions(ApiError e , HttpServletRequest request) {
        e.printStackTrace();
        log.info(e.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(HttpStatus.BAD_REQUEST,ErrorTypes.API_ERROR.toString(), ApiErrorDTO.builder().errorCode(e.getErrorCode()).errorMessage(e.getErrorMessage()).build()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({AuthorizationException.class})
    public ResponseEntity<ApiResponse<String>> handleAuthExceptions(AuthorizationException e , HttpServletRequest request) {
        e.printStackTrace();
        log.info(e.toString());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiResponse<>(HttpStatus.FORBIDDEN,ErrorTypes.AUTH_ERROR.toString(),e.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class,RuntimeException.class})
    public ResponseEntity<ApiResponse<String>> handleOtherExceptions(Exception e , HttpServletRequest request) {
        e.printStackTrace();
        log.info(e.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(HttpStatus.BAD_REQUEST,ErrorTypes.UNEXPECTED_ERROR.toString(), e.getMessage()));
    }
}
