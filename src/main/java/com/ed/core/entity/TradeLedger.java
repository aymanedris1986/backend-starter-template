package com.ed.core.entity;

import com.ed.core.entity.base.AuditEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@Entity
@ToString
@Table(name = "trade_ledger")
public class TradeLedger implements AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ledger_entry_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private TradePortfolio portfolio;

    @NotNull
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Size(max = 5)
    @NotNull
    @Column(name = "entry_type", nullable = false, length = 5)
    private String entryType;

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