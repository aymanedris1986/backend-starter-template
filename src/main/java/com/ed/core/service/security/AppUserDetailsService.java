package com.ed.core.service.security;

import com.ed.core.dto.security.AppUser;
import com.ed.core.dto.security.ClientUserInfoDTO;
import com.ed.core.repository.SecUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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


    public static Authentication getUserAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getCurrentUserName(){
        return getUserAuthentication().getName();
    }

    public AppUser getCurrentUser(){
        return (AppUser) getUserAuthentication().getPrincipal();
    }

    public String getCurrentUserEmail(){
        return getCurrentUser().getEmail();
    }

    public String getCurrentUserId(){
        return getCurrentUser().getId();
    }

    public String getCurrentUserMainRole(){
        return getCurrentUser().getMainRole();
    }

    public List<String> getCurrentUserRoles(){
        return getCurrentUser().getRoles();
    }

    public List<String> getCurrentUserPermissions(){
        return getCurrentUser().getPermissions();
    }

    public boolean isUserHasRole(String role){
        if (getCurrentUserRoles() != null && getCurrentUserRoles().contains(role)){
            return true;
        }
        if (role.equals(getCurrentUserMainRole())){
            return true;
        }
        return false;
    }

    public boolean isUserHasPermission(String permission){
        if (getCurrentUserPermissions() != null && getCurrentUserPermissions().contains(permission)){
            return true;
        }
        return false;
    }

}
