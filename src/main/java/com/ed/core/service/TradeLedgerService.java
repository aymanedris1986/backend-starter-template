package com.ed.core.service;

import com.ed.core.dto.TradeLedgerDto;
import com.ed.core.entity.TradeLedger;
import com.ed.core.repository.TradeLedgerRepository;
import com.ed.core.service.base.AuditCrudService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TradeLedgerService extends AuditCrudService<TradeLedger,Long, TradeLedgerDto> {

    private final TradeLedgerRepository tradeLedgerRepository;

    @Override
    protected JpaRepository<TradeLedger, Long> getRepository() {
        return tradeLedgerRepository;
    }

    @Override
    protected Class<TradeLedger> getModelClassType() {
        return TradeLedger.class;
    }

    @Override
    protected Class<TradeLedgerDto> getDtoClassType() {
        return TradeLedgerDto.class;
    }

    @Override
    protected Long getDtoId(TradeLedgerDto dto) {
        return dto.getId();
    }

    @Override
    protected TradeLedger getNewModelObject() {
        return new TradeLedger();
    }

    @Override
    protected void mapLovs(TradeLedgerDto src, TradeLedger dest) {

    }
}
