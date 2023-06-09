package com.ed.core.service;

import com.ed.core.dto.TradeSplitDto;
import com.ed.core.entity.TradeSplit;
import com.ed.core.repository.TradeSplitRepository;
import com.ed.core.service.base.AuditCrudService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TradeSplitService extends AuditCrudService<TradeSplit,Long, TradeSplitDto> {

    private final TradeSplitRepository tradeSplitRepository;

    @Override
    protected JpaRepository<TradeSplit, Long> getRepository() {
        return tradeSplitRepository;
    }

    @Override
    protected Class<TradeSplit> getModelClassType() {
        return TradeSplit.class;
    }

    @Override
    protected Class<TradeSplitDto> getDtoClassType() {
        return TradeSplitDto.class;
    }

    @Override
    protected Long getDtoId(TradeSplitDto dto) {
        return dto.getId();
    }

    @Override
    protected TradeSplit getNewModelObject() {
        return new TradeSplit();
    }

    @Override
    protected void mapLovs(TradeSplitDto src, TradeSplit dest) {

    }
}
