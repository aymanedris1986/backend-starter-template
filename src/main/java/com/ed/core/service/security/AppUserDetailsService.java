package com.ed.core.service.security;

import com.ed.core.dto.security.AppUser;
import com.ed.core.entity.SecUser;
import com.ed.core.repository.SecUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private SecUserRepository secUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecUser byUserName = secUserRepository.findByUserName(username);
        return new AppUser(byUserName.getUserName(), byUserName.getPassword(), Collections.singletonList(
                new SimpleGrantedAuthority("ADMIN")
        ));
    }
}
