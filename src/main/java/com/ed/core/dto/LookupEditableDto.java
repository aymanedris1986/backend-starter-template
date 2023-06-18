package com.ed.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.ed.core.entity.Lookup}
 */
@Data
@ToString
@NoArgsConstructor
public class LookupEditableDto implements Serializable {
    Long id;
    @NotNull
    @Size(max = 200)
    String lookupType;
    @NotNull
    @Size(max = 200)
    String code;
    @Size(max = 500)
    String name;
    @Size(max = 500)
    String descriptionAr;
    Instant createdAt;
    @Size(max = 100)
    String createdBy;
    Instant updatedAt;
    @Size(max = 100)
    String updatedBy;
}