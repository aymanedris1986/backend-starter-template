package com.ed.core.controller.security;

import com.ed.core.controller.base.BaseController;
import com.ed.core.dto.security.ClientUserInfoDTO;
import com.ed.core.entity.SecUser;
import com.ed.core.service.SecUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdentityController extends BaseController {
    public static final String CONTROLLER_PATH = "/id";
    @Autowired
    private SecUsersService secUsersService;

    @GetMapping(CONTROLLER_PATH+"/me")
    public ClientUserInfoDTO getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        SecUser userByName = secUsersService.getUserByName(username);
        ClientUserInfoDTO clientUserInfoDTO = new ClientUserInfoDTO();
        clientUserInfoDTO.setId(userByName.getUserCode());
        clientUserInfoDTO.setName(username);
        clientUserInfoDTO.setEmail(userByName.getEmail());
        return clientUserInfoDTO;
    }
}
