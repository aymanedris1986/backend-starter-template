package com.ed.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sec_functions")
public class SecFunction {
    @Id
    @Size(max = 200)
    @Column(name = "function_code", nullable = false, length = 200)
    private String functionCode;

    @Size(max = 1000)
    @Column(name = "description_en", length = 1000)
    private String descriptionEn;

    @Size(max = 1000)
    @Column(name = "description_ar", length = 1000)
    private String descriptionAr;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Size(max = 100)
    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Size(max = 100)
    @Column(name = "updated_by", length = 100)
    private String updatedBy;

}