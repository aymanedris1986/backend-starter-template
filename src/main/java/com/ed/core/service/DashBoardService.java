package com.ed.core.service;

import com.ed.core.dto.DashboardNumberDto;
import com.ed.core.repository.DashboardNumberRepository;
import com.ed.core.service.base.AppService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DashBoardService extends AppService {

    private final DashboardNumberRepository dashboardNumberRepository;

    public DashboardNumberDto getDashBoardNumbers(){
        return dashboardNumberRepository.findByUsername(getUserName());
    }
}
