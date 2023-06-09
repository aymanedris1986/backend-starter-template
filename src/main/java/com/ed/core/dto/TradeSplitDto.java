package com.ed.core.dto;

import com.ed.core.entity.TradeSplit;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link TradeSplit}
 */
@Data
@NoArgsConstructor
public class TradeSplitDto implements Serializable {
    Long id;
    @NotNull
    @Size(max = 10)
    String splitDirection;
    LocalDate splitDate;
    BigDecimal splitPrice;
    BigDecimal splitSize;
    BigDecimal stopLoss;
    BigDecimal takeProfit;
    BigDecimal commission;
    @NotNull
    LocalDate createdAt;
    @Size(max = 100)
    String createdBy;
    LocalDate updatedAt;
    @Size(max = 100)
    String updatedBy;
}