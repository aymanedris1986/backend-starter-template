package com.ed.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * DTO for {@link com.ed.core.entity.SecUser}
 */
@Data
public class SecUserProfileDto implements Serializable {
    String id;
    @Size(max = 200)
    String userCode;
    @NotNull
    @Size(max = 200)
    String userName;
    @Size(max = 1000)
    String email;
    @Size(max = 400)
    String fullNameEn;
    @Size(max = 400)
    String fullNameAr;
    @Size(max = 100)
    String firstNameEn;
    @Size(max = 100)
    String firstNameAr;
    @Size(max = 100)
    String secondNameEn;
    @Size(max = 100)
    String secondNameAr;
    @Size(max = 100)
    String thirdNameEn;
    @Size(max = 100)
    String thirdNameAr;
    @Size(max = 100)
    String fourthNameEn;
    @Size(max = 100)
    String fourthNameAr;
    @Size(max = 50)
    String phone;
    @Size(max = 50)
    String mobile;
    Instant dateOfBirth;
    Instant createdAt;
    @Size(max = 100)
    String createdBy;
    Instant updatedAt;
    @Size(max = 100)
    String updatedBy;
}