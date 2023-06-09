package com.ed.core.controller;

import com.ed.core.controller.base.CrudController;
import com.ed.core.dto.TradeDto;
import com.ed.core.dto.TradeSplitDto;
import com.ed.core.dto.base.ApiResponse;
import com.ed.core.entity.Trade;
import com.ed.core.entity.TradeSplit;
import com.ed.core.service.TradeService;
import com.ed.core.service.TradeSplitService;
import com.ed.core.service.base.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TradeSplitController extends CrudController<TradeSplit,Long, TradeSplitDto>{
        public static final String CONTROLLER_PATH = "/trade-split";
            public final TradeSplitService tradeSplitService;

            @Override
            protected CrudService<TradeSplit, Long, TradeSplitDto> getCrudService() {
                return  tradeSplitService;
            }

            @Override
            @GetMapping(CONTROLLER_PATH)
            public ResponseEntity<ApiResponse<List<TradeSplitDto>>> getAll(
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
            public ResponseEntity<ApiResponse<TradeSplitDto>> findById(@PathVariable("id") Long id) {
                return super.findById(id);
            }

            @Override
            @PutMapping(CONTROLLER_PATH)
            public ResponseEntity<ApiResponse<TradeSplitDto>> update(@RequestBody TradeSplitDto dto) {
                return super.update(dto);
            }

            @Override
            @PostMapping(CONTROLLER_PATH)
            public ResponseEntity<ApiResponse<TradeSplitDto>> insert(@RequestBody TradeSplitDto dto) {
                return super.insert(dto);
            }
}
