package com.ed.core.service;

import com.ed.core.dto.TradeDto;
import com.ed.core.entity.Trade;
import com.ed.core.entity.TradeSplit;
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

    @Override
    protected Trade preInsert(Trade model, TradeDto dto) {
        TradeSplit tradeSplit = new TradeSplit();
        tradeSplit.setTrade(model);
        model.setTradeSplit(tradeSplit);
        mapAttributes(dto, tradeSplit);
        insertAudit(tradeSplit);
        return super.preInsert(model, dto);
    }

    private static void mapAttributes(TradeDto dto, TradeSplit tradeSplit) {
        tradeSplit.setSplitDirection(dto.getDirection());
        tradeSplit.setSplitDate(dto.getTradeSplitSplitDate());
        tradeSplit.setCommission(dto.getTradeSplitCommission());
        tradeSplit.setSplitPrice(dto.getTradeSplitSplitPrice());
        tradeSplit.setSplitSize(dto.getTradeSplitSplitSize());
        tradeSplit.setStopLoss(dto.getTradeSplitStopLoss());
    }

    @Override
    protected Trade preUpdate(Trade model, TradeDto dto) {
        TradeSplit reference = getReference(dto.getTradeSplitId(), TradeSplit.class);
        model.setTradeSplit(reference);
        updateAudit(reference);
        mapAttributes(dto,reference);
        return super.preUpdate(model, dto);
    }
}
