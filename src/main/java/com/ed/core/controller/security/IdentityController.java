package com.ed.core.controller.security;

import com.ed.core.controller.base.AppController;
import com.ed.core.dto.security.ClientUserInfoDTO;
import com.ed.core.service.security.SecUsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ed.core.utils.SecurityUtils.getCurrentUserName;

@RestController
@AllArgsConstructor
public class IdentityController extends AppController {
    public static final String CONTROLLER_PATH = "/id";

    private final SecUsersService secUsersService;

    @GetMapping(CONTROLLER_PATH + "/me")
    public ClientUserInfoDTO getUserInfo() {
        return secUsersService.getUserWithRolesAndPermissions(getCurrentUserName(),false);
    }
}
