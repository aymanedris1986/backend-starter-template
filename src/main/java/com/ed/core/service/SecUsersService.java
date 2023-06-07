package com.ed.core.service;

import com.ed.core.entity.SecUser;
import com.ed.core.repository.SecUserRepository;
import com.ed.core.service.base.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecUsersService extends BaseService {

    private final SecUserRepository secUserRepository;

    public SecUser getUserByName(String username){
        return secUserRepository.findByUserName(username);
    }
}
