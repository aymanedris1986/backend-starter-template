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
public class PermissionAuthorizationAspect {
    private final AppUserDetailsService userDetailsService;

    @Around("@annotation(com.ed.core.aspect.security.PermissionAuthorization)")
    public Object applyCustomAuthorization(ProceedingJoinPoint joinPoint) throws Throwable {
        PermissionAuthorization permissionAspect = AspectUtils.getAnnotation(joinPoint,PermissionAuthorization.class);
        String[] permissions = permissionAspect.permissions();
        if(permissions != null && permissions.length > 0){
            for (int i = 0; i < permissions.length; i++) {
                if (userDetailsService.isUserHasPermission(permissions[i])){
                    return joinPoint.proceed();
                }
            }
        }else {
            return joinPoint.proceed();
        }
        throw new AuthorizationException("Not authorized");
    }
}
