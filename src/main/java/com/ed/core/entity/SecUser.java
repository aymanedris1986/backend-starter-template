package com.ed.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    @NotNull
    @Column(name = "FULL_NAME", nullable = false, length = 1000)
    private String fullName;

    @Size(max = 1000)
    @Column(name = "EMAIL", length = 1000)
    private String email;

    @Size(max = 50)
    @Column(name = "PHONE1", length = 50)
    private String phone1;

    @Size(max = 1000)
    @NotNull
    @Column(name = "PASSWORD", nullable = false, length = 1000)
    private String password;

}