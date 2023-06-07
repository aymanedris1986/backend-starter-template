package com.ed.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "REGIONS")
public class Region {
    @Id
    @Column(name = "REGION_ID", nullable = false)
    private Long id;

    @Size(max = 25)
    @Column(name = "REGION_NAME", length = 25)
    private String regionName;

    @NotNull
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @Size(max = 100)
    @Column(name = "CREATED_BY", length = 100)
    private String createdBy;

    @Column(name = "UPDATED_AT")
    private LocalDate updatedAt;

    @Size(max = 100)
    @Column(name = "UPDATED_BY", length = 100)
    private String updatedBy;

}