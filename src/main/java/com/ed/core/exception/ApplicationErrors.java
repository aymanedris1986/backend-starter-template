package com.ed.core.exception;

public enum ApplicationErrors {
    RECORD_ALREADY_EXISTS("0001", "Record Already Exists");

    private String key;
    private String value;

    ApplicationErrors(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
