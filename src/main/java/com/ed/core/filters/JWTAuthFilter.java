package com.ed.core.filters;

import com.ed.core.dto.security.AppUser;
import com.ed.core.dto.security.ClientUserInfoDTO;
import com.ed.core.utils.SecurityUtils;
import com.ed.core.utils.Utils;
import com.ed.core.service.security.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.*;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;
    @Autowired
    private AntPathMatcher antPathMatcher;
    @Value("${baseurl}")
    private String baseUrl;
    @Value("${public.urls}")
    private String publicUrls;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = null;
        if (isPublicUrl(request)) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            final String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                SecurityUtils.setUnAuthorizedResponse(response);
                return;
            }
            token = getToken(authHeader);
            boolean tokenValid = jwtService.isTokenValid(token);
            if (!tokenValid) {
                SecurityUtils.setUnAuthorizedResponse(response);
                return;
            }
        } catch (Exception ex) {
            SecurityUtils.setUnAuthorizedResponse(response);
            return;
        }
        authenticate(request, token);
        filterChain.doFilter(request, response);
    }

    private boolean isPublicUrl(HttpServletRequest request) {
        ///api/auth/**
        if (Utils.isNullOrEmpty(publicUrls)) {
            return false;
        }
        String servletPath = request.getServletPath();
        String[] urls = publicUrls.split(",");
        return Arrays.stream(urls).filter(
                url -> antPathMatcher.match(url, servletPath)
        ).count() > 0;
    }

    private String getToken(String authHeader) {
        final String jwt = authHeader.substring(7);
        return jwt;
    }

    private void authenticate(HttpServletRequest request, String token) {
        AppUser userDetails = jwtService.tokenToUser(token);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );
        authToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }




}
