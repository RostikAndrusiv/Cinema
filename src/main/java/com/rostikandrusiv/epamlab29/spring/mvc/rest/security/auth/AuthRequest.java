package com.rostikandrusiv.epamlab29.spring.mvc.rest.security.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}