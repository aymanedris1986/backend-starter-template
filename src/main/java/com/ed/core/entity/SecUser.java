package com.ed.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SEC_USERS")
public class SecUser {
    @Id
    @Size(max = 200)
    @Column(name = "USER_CODE", nullable = false, length = 200)
    private String userCode;

    @Size(max = 200)
    @NotNull
    @Column(name = "USER_NAME", nullable = false, length = 200)
    private String userName;


    @Size(max = 1000)
    @Column(name = "EMAIL", length = 1000)
    private String email;

    @Size(max = 1000)
    @NotNull
    @Column(name = "PASSWORD", nullable = false, length = 1000)
    private String password;

    @Size(max = 400)
    @Column(name = "FULL_NAME_EN", length = 400)
    private String fullNameEn;

    @Size(max = 400)
    @Column(name = "FULL_NAME_AR", length = 400)
    private String fullNameAr;

    @Size(max = 100)
    @Column(name = "FIRST_NAME_EN", length = 100)
    private String firstNameEn;

    @Size(max = 100)
    @Column(name = "FIRST_NAME_AR", length = 100)
    private String firstNameAr;

    @Size(max = 100)
    @Column(name = "SECOND_NAME_EN", length = 100)
    private String secondNameEn;

    @Size(max = 100)
    @Column(name = "SECOND_NAME_AR", length = 100)
    private String secondNameAr;

    @Size(max = 100)
    @Column(name = "THIRD_NAME_EN", length = 100)
    private String thirdNameEn;

    @Size(max = 100)
    @Column(name = "THIRD_NAME_AR", length = 100)
    private String thirdNameAr;

    @Size(max = 100)
    @Column(name = "FOURTH_NAME_EN", length = 100)
    private String fourthNameEn;

    @Size(max = 100)
    @Column(name = "FOURTH_NAME_AR", length = 100)
    private String fourthNameAr;

    @Size(max = 50)
    @Column(name = "PHONE", length = 50)
    private String phone;

    @Size(max = 50)
    @Column(name = "MOBILE", length = 50)
    private String mobile;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;


    @Column(name = "CREATED_AT")
    private Instant createdAt;

    @Size(max = 100)
    @Column(name = "CREATED_BY", length = 100)
    private String createdBy;

    @Column(name = "UPDATED_AT")
    private Instant updatedAt;

    @Size(max = 100)
    @Column(name = "UPDATED_BY", length = 100)
    private String updatedBy;

    @OneToMany(mappedBy = "userCode")
    private List<SecUserRole> secUserRoles = new ArrayList<>();

    @OneToMany(mappedBy = "userCode")
    private List<SecUserFunction> secUserFunctions = new ArrayList<>();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_main_role", nullable = false)
    private SecRole userMainRole;

}