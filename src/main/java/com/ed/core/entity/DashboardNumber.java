package com.ed.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "dashboard_numbers")
public class DashboardNumber {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "dbcard1")
    private Integer dbcard1;

    @Column(name = "dbcard2")
    private Integer dbcard2;

    @Column(name = "dbcard3")
    private Integer dbcard3;

    @Column(name = "dbcard4")
    private Integer dbcard4;

    @Column(name = "dbcard5")
    private Integer dbcard5;

    @Column(name = "dbcard6")
    private Integer dbcard6;

    @Column(name = "dbcard7")
    private Integer dbcard7;

    @Column(name = "dbcard8")
    private Integer dbcard8;

    @Size(max = 200)
    @Column(name = "username", length = 200)
    private String username;

}