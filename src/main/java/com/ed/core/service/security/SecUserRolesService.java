package com.ed.core.service.security;

import com.ed.core.repository.SecUserRoleRepository;
import com.ed.core.service.base.AppService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecUserRolesService  extends AppService {
    private final SecUserRoleRepository secUserRoleRepository;
}
