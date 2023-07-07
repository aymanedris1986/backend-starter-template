package com.ed.core.dto;

import com.ed.core.entity.TradeLedger;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link TradeLedger}
 */
@Data
@ToString
@NoArgsConstructor
public class TradeLedgerDto implements Serializable {
    Long id;
    Long portfolioId;
    String portfolioPortfolioName;
    @NotNull
    BigDecimal amount;
    @NotNull
    @Size(max = 5)
    String entryType;
    @NotNull
    Instant createdAt;
    @Size(max = 100)
    String createdBy;
    Instant updatedAt;
    @Size(max = 100)
    String updatedBy;
}