package com.ed.core.controller;
import com.ed.core.controller.base.CrudController;
import com.ed.core.dto.TradeLedgerDto;
import com.ed.core.dto.TradePortfolioDto;
import com.ed.core.dto.base.ApiResponse;
import com.ed.core.entity.TradePortfolio;
import com.ed.core.service.TradePortfolioService;
import com.ed.core.service.base.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TradePortfolioController extends CrudController<TradePortfolio,Long, TradePortfolioDto>{
        public static final String CONTROLLER_PATH = "/trade-portfolio";
            public final TradePortfolioService tradePortfolioService;

            @Override
            protected CrudService<TradePortfolio, Long, TradePortfolioDto> getCrudService() {
                return  tradePortfolioService;
            }

            @Override
            @GetMapping(CONTROLLER_PATH)
            public ResponseEntity<ApiResponse<List<TradePortfolioDto>>> getAll(
                    @RequestParam(defaultValue = "0") int page,
                    @RequestParam(defaultValue = "10") int size) {
                return super.getAll(page, size);
            }

            @Override
            @GetMapping(CONTROLLER_PATH+"/count")
            public ResponseEntity<ApiResponse<Long>> getAllCount() {
                return super.getAllCount();
            }

            @Override
            @GetMapping(CONTROLLER_PATH + "/{id}")
            public ResponseEntity<ApiResponse<TradePortfolioDto>> findById(@PathVariable("id") Long id) {
                return super.findById(id);
            }

            @Override
            @PutMapping(CONTROLLER_PATH)
            public ResponseEntity<ApiResponse<TradePortfolioDto>> update(@RequestBody TradePortfolioDto dto) {
                return super.update(dto);
            }

            @Override
            @PostMapping(CONTROLLER_PATH)
            public ResponseEntity<ApiResponse<TradePortfolioDto>> insert(@RequestBody TradePortfolioDto dto) {
                return super.insert(dto);
            }
}
