package com.ed.core.service;

import com.ed.core.dto.TradeDto;
import com.ed.core.entity.Trade;
import com.ed.core.repository.TradeRepository;
import com.ed.core.service.base.AuditCrudService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TradeService extends AuditCrudService<Trade,Long, TradeDto> {

    private final TradeRepository tradeRepository;

    @Override
    protected JpaRepository<Trade, Long> getRepository() {
        return tradeRepository;
    }

    @Override
    protected Class<Trade> getModelClassType() {
        return Trade.class;
    }

    @Override
    protected Class<TradeDto> getDtoClassType() {
        return TradeDto.class;
    }

    @Override
    protected Long getDtoId(TradeDto dto) {
        return dto.getId();
    }

    @Override
    protected Trade getNewModelObject() {
        return new Trade();
    }

    @Override
    protected void mapLovs(TradeDto src, Trade dest) {

    }
}
