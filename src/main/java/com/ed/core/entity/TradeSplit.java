package com.ed.core.entity;

import com.ed.core.entity.base.AuditEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "trade_splits")
public class TradeSplit  implements AuditEntity {
    @Id
    @Column(name = "trade_split_id", nullable = false)
    private Long id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trade_id", nullable = false)
    private Trade trade;

    @Size(max = 10)
    @NotNull
    @Column(name = "split_direction", nullable = false, length = 10)
    private String splitDirection;

    @Column(name = "split_date")
    private LocalDate splitDate;

    @Column(name = "split_price", precision = 10, scale = 2)
    private BigDecimal splitPrice;

    @Column(name = "split_size", precision = 10, scale = 2)
    private BigDecimal splitSize;

    @Column(name = "stop_loss", precision = 10, scale = 2)
    private BigDecimal stopLoss;

    @Column(name = "take_profit", precision = 10, scale = 2)
    private BigDecimal takeProfit;

    @Column(name = "commission", precision = 10, scale = 2)
    private BigDecimal commission;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Size(max = 100)
    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Size(max = 100)
    @Column(name = "updated_by", length = 100)
    private String updatedBy;

}