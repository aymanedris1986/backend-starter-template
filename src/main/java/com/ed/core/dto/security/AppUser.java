package com.ed.core.dto.security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ToString
@Getter
@Setter
public class AppUser extends User {
    private String mainRole;
    private String id;
    private String name;
    private String email;
    private List<String> roles = new ArrayList<>();
    private List<String> permissions = new ArrayList<>();
    public AppUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
