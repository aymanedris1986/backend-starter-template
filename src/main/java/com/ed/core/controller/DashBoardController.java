package com.ed.core.controller;

import com.ed.core.controller.base.AppController;
import com.ed.core.controller.base.CrudController;
import com.ed.core.dto.DashboardNumberDto;
import com.ed.core.dto.base.ApiResponse;
import com.ed.core.service.DashBoardService;
import com.ed.core.service.base.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
public class DashBoardController extends AppController {
    public static final String CONTROLLER_PATH = "/dash-board";
    private final DashBoardService dashBoardService;
    @GetMapping(CONTROLLER_PATH+"/numbers")
    public ResponseEntity<ApiResponse<DashboardNumberDto>> getDashboardNumbers(){
        return generateSuccessResponse(dashBoardService.getDashBoardNumbers());
    }
}
