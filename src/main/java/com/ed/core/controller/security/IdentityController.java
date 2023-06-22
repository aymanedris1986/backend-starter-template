package com.ed.core.controller.security;

import com.ed.core.controller.base.AppController;
import com.ed.core.dto.security.ClientUserInfoDTO;
import com.ed.core.entity.SecUser;
import com.ed.core.service.SecUsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ed.core.utils.SecurityUtils.getCurrentUserName;

@RestController
@AllArgsConstructor
public class IdentityController extends AppController {
    public static final String CONTROLLER_PATH = "/id";

    private final SecUsersService secUsersService;

    @GetMapping(CONTROLLER_PATH+"/me")
    public ClientUserInfoDTO getUserInfo(){
        String username = getCurrentUserName();
        SecUser userByName = secUsersService.getUserByName(username);
        ClientUserInfoDTO clientUserInfoDTO = new ClientUserInfoDTO();
        clientUserInfoDTO.setId(userByName.getUserCode());
        clientUserInfoDTO.setName(username);
        clientUserInfoDTO.setEmail(userByName.getEmail());
        return clientUserInfoDTO;
    }
}
