package com.ed.core.service.security;

import com.ed.core.dto.security.AppUser;
import com.ed.core.dto.security.ClientUserInfoDTO;
import com.ed.core.dto.security.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private final JWTService jwtService;


    public String login(UserCredentials userCredentials) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword()));
        AppUser userDetails = (AppUser) userDetailsService.loadUserByUsername(userCredentials.getUsername());
        return jwtService.userToToken(userDetails);
    }




}
