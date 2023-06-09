package com.ed.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "lookups")
public class Lookup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lookup_seq", nullable = false)
    private Long id;

    @Size(max = 200)
    @NotNull
    @Column(name = "lookup_type", nullable = false, length = 200)
    private String lookupType;

    @Size(max = 200)
    @NotNull
    @Column(name = "lookup_value", nullable = false, length = 200)
    private String lookupValue;

    @Size(max = 500)
    @Column(name = "description_en", length = 500)
    private String descriptionEn;

    @Size(max = 500)
    @Column(name = "description_ar", length = 500)
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