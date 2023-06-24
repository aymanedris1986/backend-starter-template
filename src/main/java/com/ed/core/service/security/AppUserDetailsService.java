package com.ed.core.service.security;

import com.ed.core.dto.security.AppUser;
import com.ed.core.dto.security.ClientUserInfoDTO;
import com.ed.core.repository.SecUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private SecUserRepository secUserRepository;
    @Autowired
    private SecUsersService secUsersService;

    @Override
    public AppUser loadUserByUsername(String username) throws UsernameNotFoundException {
        ClientUserInfoDTO userInfoDTO = secUsersService.getUserWithRolesAndPermissions(username,true);
        AppUser user = new AppUser(username,userInfoDTO.getPassword(),new ArrayList<>());
        user.setId(userInfoDTO.getId());
        user.setName(userInfoDTO.getName());
        user.setEmail(userInfoDTO.getEmail());
        user.setMainRole(userInfoDTO.getMainRole());
        user.setRoles(userInfoDTO.getRoles());
        user.setPermissions(userInfoDTO.getPermissions());
        return user;
    }
}
