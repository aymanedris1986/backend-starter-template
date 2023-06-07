package com.ed.core.exception;

import com.ed.core.dto.exception.ValidationErrorsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ValidationException extends RuntimeException{
    private ValidationErrorsDTO validationErrorsDTO;
}
