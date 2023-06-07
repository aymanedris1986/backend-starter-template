package com.ed.core.dto.exception;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class ValidationErrorsDTO {
    private Map<String,String> validationErrors = new HashMap<>();

    public ValidationErrorsDTO(){

    }

    public ValidationErrorsDTO(String errorCode,String errorMessage){
        addError(errorCode,errorMessage);
    }

    public void addError(String errorCode,String errorMessage){
        validationErrors.put(errorCode,errorMessage);
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public boolean hasErrors(){
        return !validationErrors.isEmpty();
    }
}
