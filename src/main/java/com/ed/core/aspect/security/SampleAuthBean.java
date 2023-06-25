package com.ed.core.aspect.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Qualifier("sampleAuthBean")
public class SampleAuthBean implements SecAuthorizer{
    @Override
    public void doAuthorize(ProceedingJoinPoint joinPoint, Map<String, Object> additionalAttributes) {
        System.out.println("hello from SampleAuthBean");
        System.out.println(joinPoint);

        // Get the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        // Get the parameter names
        ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        String[] parameterNames = parameterNameDiscoverer.getParameterNames(methodSignature.getMethod());

        // Get the arguments
        Object[] args = joinPoint.getArgs();

        // Print the parameter names and argument values
        if (parameterNames != null) {
            for (int i = 0; i < parameterNames.length; i++) {
                String parameterName = parameterNames[i];
                Object argument = args[i];
                System.out.println("Parameter: " + parameterName);
                System.out.println("Value: " + argument);
            }
        }
    }
}
