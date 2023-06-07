package com.ed.core.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@ToString
@Data
public class BaseApiResponse<T> {
    private HttpStatus httpStatus;
    private String message;
    private  T data;
}
