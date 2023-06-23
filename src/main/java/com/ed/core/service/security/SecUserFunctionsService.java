package com.ed.core.service.security;

import com.ed.core.repository.SecUserFunctionRepository;
import com.ed.core.service.base.AppService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecUserFunctionsService extends AppService {
    private final SecUserFunctionRepository secUserFunctionRepository;
}
