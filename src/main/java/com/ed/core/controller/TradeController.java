package com.ed.core.controller;

import com.ed.core.controller.base.CrudController;
import com.ed.core.dto.TradeDto;
import com.ed.core.dto.base.ApiResponse;
import com.ed.core.entity.Trade;
import com.ed.core.service.TradeService;
import com.ed.core.service.base.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TradeController extends CrudController<Trade, Long, TradeDto> {
    public static final String CONTROLLER_PATH = "/trade";
    public final TradeService tradeService;

    @Override
    protected CrudService<Trade, Long, TradeDto> getCrudService() {
        return tradeService;
    }

    @Override
    @GetMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<List<TradeDto>>> getAll(
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
    public ResponseEntity<ApiResponse<TradeDto>> findById(@PathVariable("id") Long id) {
        return super.findById(id);
    }

    @Override
    @PutMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<TradeDto>> update(@RequestBody TradeDto dto) {
        return super.update(dto);
    }

    @Override
    @PostMapping(CONTROLLER_PATH)
    public ResponseEntity<ApiResponse<TradeDto>> insert(@RequestBody TradeDto dto) {
        return super.insert(dto);
    }
}
