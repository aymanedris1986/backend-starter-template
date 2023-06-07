package com.ed.core.dto.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class BaseModelDTO {
    private final List<String> warnings = new ArrayList<>();

    public void addWarning(String warning){
        warnings.add(warning);
    }
}
