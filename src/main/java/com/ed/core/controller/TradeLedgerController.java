package com.ed.core.controller;

import com.ed.core.controller.base.CrudController;
import com.ed.core.dto.TradeLedgerDto;
import com.ed.core.dto.base.ApiResponse;
import com.ed.core.entity.TradeLedger;
import com.ed.core.entity.TradePortfolio;
import com.ed.core.service.TradeLedgerService;
import com.ed.core.service.base.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TradeLedgerController extends CrudController<TradeLedger, Long, TradeLedgerDto> {
    public static final String CONTROLLER_PATH = "/trade-ledger";
    public final TradeLedgerService tradeLedgerService;

    @Override
    protected CrudService<TradeLedger, Long, TradeLedgerDto> getCrudService() {
        return tradeLedgerService;
    }

    @Override
    @GetMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<List<TradeLedgerDto>>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return super.getAll(page, size);
    }

    @Override
    @GetMapping(CONTROLLER_PATH + "/count")
    public ResponseEntity<ApiResponse<Long>> getAllCount() {
        return super.getAllCount();
    }

    @Override
    @GetMapping(CONTROLLER_PATH + "/{id}")
    public ResponseEntity<ApiResponse<TradeLedgerDto>> findById(@PathVariable("id") Long id) {
        return super.findById(id);
    }

    @Override
    @PutMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<TradeLedgerDto>> update(@RequestBody TradeLedgerDto dto) {
        return super.update(dto);
    }

    @Override
    @PostMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<TradeLedgerDto>> insert(@RequestBody TradeLedgerDto dto) {
        return super.insert(dto);
    }
}
