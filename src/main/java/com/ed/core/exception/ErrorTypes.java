package com.ed.core.exception;

public enum ErrorTypes {
    UNEXPECTED_ERROR("UNEXPECTED_ERROR"),
    API_ERROR("API_ERROR"),
    VALIDATION_ERROR("VALIDATION_ERROR"),
    AUTH_ERROR("AUTH_ERROR");
    private String type;
    ErrorTypes(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
