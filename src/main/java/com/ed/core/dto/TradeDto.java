package com.ed.core.dto;

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
 * DTO for {@link com.ed.core.entity.Trade}
 */
@Data
@ToString
@NoArgsConstructor
public class TradeDto implements Serializable {
    Long id;
    @NotNull
    @Size(max = 50)
    String symbol;
    @NotNull
    @Size(max = 10)
    String direction;
    @NotNull
    Instant entryDate;
    Instant exitDate;
    @Size(max = 2000)
    String notes;
    Instant createdAt;
    @Size(max = 100)
    String createdBy;
    Instant updatedAt;
    @Size(max = 100)
    String updatedBy;
    private Long tradeSplitId;
    private String tradeSplitSplitDirection;
    private Instant tradeSplitSplitDate;
    private BigDecimal tradeSplitSplitPrice;
    private BigDecimal tradeSplitSplitSize;
    private BigDecimal tradeSplitStopLoss;
    private BigDecimal tradeSplitTakeProfit;
    private BigDecimal tradeSplitCommission;
    private Instant tradeSplitCreatedAt;
    private String tradeSplitCreatedBy;
    private Instant tradeSplitUpdatedAt;
    private String tradeSplitUpdatedBy;
}