package com.ed.core.dto.security;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ClientUserInfoDTO {
    private String id;
    private String name;
    private String password;
    private String email;
    private String avatar;
    private String mainRole;
    private List<String> roles = new ArrayList<>();
    private List<String> permissions = new ArrayList<>();
}
