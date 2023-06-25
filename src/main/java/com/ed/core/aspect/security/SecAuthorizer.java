package com.ed.core.aspect.security;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Map;


public interface SecAuthorizer {
    public void doAuthorize(ProceedingJoinPoint joinPoint, Map<String,Object> additionalAttributes);
}
