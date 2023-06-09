package com.ed.core.controller;


import com.ed.core.controller.base.AppController;
import com.ed.core.dto.LOVDTO;
import com.ed.core.service.LOVService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class LOVController extends AppController {

    public static final String CONTROLLER_PATH = "/lov";
    private LOVService lovService;

    @GetMapping(CONTROLLER_PATH)
    public ResponseEntity<List<LOVDTO>> getAll(@RequestParam("type") String lovType) {
        return ResponseEntity.ok(lovService.getLovByType(lovType));
        //return ResponseEntity.ok(null);
    }
}
