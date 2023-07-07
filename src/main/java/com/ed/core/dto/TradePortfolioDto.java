package com.ed.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.ed.core.entity.TradePortfolio}
 */
@Data
@ToString
@NoArgsConstructor
public class TradePortfolioDto implements Serializable {
    Long id;
    @NotNull
    @Size(max = 400)
    String portfolioName;
    @NotNull
    @Size(max = 100)
    String portfolioOwnerUser;
    @NotNull
    Instant createdAt;
    @Size(max = 100)
    String createdBy;
    Instant updatedAt;
    @Size(max = 100)
    String updatedBy;
}