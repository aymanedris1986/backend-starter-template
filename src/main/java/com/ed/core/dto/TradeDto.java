package com.ed.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.ed.core.entity.Trade}
 */
@Data
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
    LocalDate entryDate;
    LocalDate exitDate;
    @Size(max = 2000)
    String notes;
    @NotNull
    LocalDate createdAt;
    @Size(max = 100)
    String createdBy;
    LocalDate updatedAt;
    @Size(max = 100)
    String updatedBy;
    TradeSplitDto tradeSplit;
}