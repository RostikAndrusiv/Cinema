package com.rostikandrusiv.epamlab29.spring.mvc.rest.security.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;
}