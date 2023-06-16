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
@Table(name = "trades")
public class Trade implements AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "symbol", nullable = false, length = 50)
    private String symbol;

    @Size(max = 10)
    @NotNull
    @Column(name = "direction", nullable = false, length = 10)
    private String direction;

    @NotNull
    @Column(name = "entry_date", nullable = false)
    private Instant entryDate;

    @Column(name = "exit_date")
    private Instant exitDate;

    @Size(max = 2000)
    @Column(name = "notes", length = 2000)
    private String notes;

    @Column(name = "created_at")
    private Instant createdAt;

    @Size(max = 100)
    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Size(max = 100)
    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @OneToOne(mappedBy = "trade",cascade=CascadeType.ALL)
    private TradeSplit tradeSplit;

}