package com.ed.core.aspect.security;


import com.ed.core.exception.AuthorizationException;
import com.ed.core.service.security.AppUserDetailsService;
import com.ed.core.utils.AspectUtils;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class RoleAuthorizationAspect {
    private final AppUserDetailsService userDetailsService;

    @Around("@annotation(com.ed.core.aspect.security.RoleAuthorization)")
    public Object applyCustomAuthorization(ProceedingJoinPoint joinPoint) throws Throwable {
        RoleAuthorization roleAspect = AspectUtils.getAnnotation(joinPoint,RoleAuthorization.class);
        String[] roles = roleAspect.roles();
        if(roles != null && roles.length > 0){
            for (int i = 0; i < roles.length; i++) {
                if (userDetailsService.isUserHasRole(roles[i])){
                    return joinPoint.proceed();
                }
                if(userDetailsService.getCurrentUserMainRole().equals(roles[i])){
                    return joinPoint.proceed();
                }
            }
        }else {
            return joinPoint.proceed();
        }
        throw new AuthorizationException("Not authorized");
    }
}
