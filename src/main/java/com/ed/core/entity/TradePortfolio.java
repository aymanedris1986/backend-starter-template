package com.ed.core.entity;

import com.ed.core.entity.base.AuditEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@ToString
@Table(name = "trade_portfolio")
public class TradePortfolio implements AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id", nullable = false)
    private Long id;

    @Size(max = 400)
    @NotNull
    @Column(name = "portfolio_name", nullable = false, length = 400)
    private String portfolioName;

    @Size(max = 100)
    @NotNull
    @Column(name = "portfolio_owner_user", nullable = false, length = 100)
    private String portfolioOwnerUser;

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

    @OneToMany(mappedBy = "portfolio")
    private Set<TradeLedger> tradeLedgers = new LinkedHashSet<>();

}