package com.ed.core.dto;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ed.core.entity.DashboardNumber}
 */
@Value
public class DashboardNumberDto implements Serializable {
    Integer id;
    Integer dbcard1;
    Integer dbcard2;
    Integer dbcard3;
    Integer dbcard4;
    Integer dbcard5;
    Integer dbcard6;
    Integer dbcard7;
    Integer dbcard8;
    @Size(max = 200)
    String username;
}