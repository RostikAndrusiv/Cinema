package com.rostikandrusiv.epamlab29.spring.mvc.rest.api;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.MovieModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.UserModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnCreate;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.security.auth.AuthRequest;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.security.auth.AuthResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Auth management API")
@RequestMapping("/api/v1")
public interface AuthApi {

    @ApiOperation("Register new user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    UserModel registerUser(@RequestBody @Validated(OnCreate.class) UserDto userDto);

    @ApiOperation("Authorisation")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/auth")
    AuthResponse auth(@RequestBody AuthRequest request);
}
