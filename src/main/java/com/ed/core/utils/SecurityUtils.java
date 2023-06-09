package com.ed.core.utils;

import com.ed.core.dto.base.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.io.PrintWriter;

public class SecurityUtils {

    public static void setUnAuthorizedResponse(HttpServletResponse response) throws IOException {
        ApiResponse apiResponse = new ApiResponse<>(HttpStatus.UNAUTHORIZED,"UNAUTHORIZED","UNAUTHORIZED");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        out.print(objectMapper.writeValueAsString(apiResponse));
        out.flush();
        out.close();
    }

    public static Authentication getUserAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getCurrentUserName(){
        return getUserAuthentication().getName();
    }
}
