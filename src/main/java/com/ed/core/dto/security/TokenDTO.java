package com.ed.core.dto.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
    private String access_token;
    private String token_type;
    private Long expires_in;
    private Long exp;
    private String refresh_token;
    private Long refresh_token_exp;
}
