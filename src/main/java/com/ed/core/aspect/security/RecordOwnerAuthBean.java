package com.ed.core.aspect.security;

import com.ed.core.dto.TradeDto;
import com.ed.core.dto.base.ApiResponse;
import com.ed.core.service.security.AppUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component
@Qualifier("recordOwnerAuthBean")
public class RecordOwnerAuthBean  implements SecAuthorizer{
    private final AppUserDetailsService userDetailsService;
    @Override
    public Object doAuthorize(ProceedingJoinPoint joinPoint, Map<String, Object> additionalAttributes) throws Throwable {
       Object response = joinPoint.proceed();
        System.out.println(response.getClass());
        ResponseEntity<ApiResponse<TradeDto>> trade = (ResponseEntity<ApiResponse<TradeDto>>) response;
        
       return response;
    }
}
