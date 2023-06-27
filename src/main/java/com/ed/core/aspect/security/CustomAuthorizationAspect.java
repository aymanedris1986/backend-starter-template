package com.ed.core.aspect.security;

import com.ed.core.service.security.AppUserDetailsService;
import com.ed.core.utils.AspectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

@Aspect
@Component
@RequiredArgsConstructor
public class CustomAuthorizationAspect {
    private final AppUserDetailsService userDetailsService;
    private final ApplicationContext applicationContext;

    @Around("@annotation(com.ed.core.aspect.security.CustomAuthorization)")
    public Object applyCustomAuthorization(ProceedingJoinPoint joinPoint) throws Throwable {
        CustomAuthorization authAspect = AspectUtils.getAnnotation(joinPoint,CustomAuthorization.class);

        String authorizerBeanName = authAspect.authorizerBean();
        SecAuthorizer secAuthorizer  = (SecAuthorizer) applicationContext.getBean(authorizerBeanName);
        secAuthorizer.doAuthorize(joinPoint,new HashMap<>());

        return joinPoint.proceed();
    }
}
