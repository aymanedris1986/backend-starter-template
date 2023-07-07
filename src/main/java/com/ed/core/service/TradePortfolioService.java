package com.ed.core.service;

import com.ed.core.dto.TradePortfolioDto;
import com.ed.core.entity.TradePortfolio;
import com.ed.core.repository.TradePortfolioRepository;
import com.ed.core.service.base.AuditCrudService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TradePortfolioService extends AuditCrudService<TradePortfolio,Long, TradePortfolioDto> {

    private final TradePortfolioRepository tradePortfolioRepository;

    @Override
    protected JpaRepository<TradePortfolio, Long> getRepository() {
        return tradePortfolioRepository;
    }

    @Override
    protected Class<TradePortfolio> getModelClassType() {
        return TradePortfolio.class;
    }

    @Override
    protected Class<TradePortfolioDto> getDtoClassType() {
        return TradePortfolioDto.class;
    }

    @Override
    protected Long getDtoId(TradePortfolioDto dto) {
        return dto.getId();
    }

    @Override
    protected TradePortfolio getNewModelObject() {
        return new TradePortfolio();
    }

    @Override
    protected void mapLovs(TradePortfolioDto src, TradePortfolio dest) {

    }
}
