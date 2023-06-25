package com.ed.core.utils;

import com.ed.core.aspect.security.CustomAuthorization;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;


public class AspectUtils {
    public static Method getMethod(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        String methodName = joinPoint.getSignature().getName();
        Class<?>[] parameterTypes = Arrays.stream(joinPoint.getSignature().getDeclaringType().getMethods())
                .filter(method -> method.getName().equals(methodName))
                .findFirst()
                .map(Method::getParameterTypes)
                .orElse(new Class<?>[0]);

        return joinPoint.getTarget().getClass().getMethod(methodName, parameterTypes);
    }

    public static <T extends Annotation> T getAnnotation(ProceedingJoinPoint joinPoint,Class<T> annotationClass) throws NoSuchMethodException {
        return getMethod(joinPoint).getAnnotation(annotationClass);
    }
}
