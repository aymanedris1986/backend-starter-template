package com.ed.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.ed.core.entity.Region}
 */
@Data

public class RegionDto implements Serializable {
    Long id;
    @Size(max = 25)
    String regionName;
    @NotNull
    LocalDate createdAt;
    @Size(max = 100)
    String createdBy;
    LocalDate updatedAt;
    @Size(max = 100)
    String updatedBy;
}