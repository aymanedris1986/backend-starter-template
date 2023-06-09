package com.ed.core.controller.security;

import com.ed.core.controller.base.AppController;
import com.ed.core.dto.security.TokenDTO;
import com.ed.core.dto.security.UserCredentials;
import com.ed.core.dto.base.ApiResponse;
import com.ed.core.service.security.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityController extends AppController {
    public static final String CONTROLLER_PATH = "/auth";
    private final AuthService authService;

    @PostMapping(CONTROLLER_PATH+"/login")
    public TokenDTO authenticate(@RequestBody UserCredentials userCredentials){
        String login = authService.login(userCredentials);
        return new TokenDTO(login,"bearer");
    }

    @PostMapping(CONTROLLER_PATH+"/logout")
    public ResponseEntity<ApiResponse<String>> logout(){
        return generateSuccessResponse("logged out");
    }
}
