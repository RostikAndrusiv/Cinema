package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.api.AuthApi;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler.UserAssembler;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.UserModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.security.auth.AuthRequest;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.security.auth.AuthResponse;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.security.jwt.JwtProvider;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.UserService;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class AuthController implements AuthApi {
    private final UserService userService;
    private final UserAssembler userAssembler;
    private final JwtProvider jwtProvider;

    public AuthController(UserService userService, UserAssembler userAssembler, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
        this.userAssembler = userAssembler;
    }

    public UserModel registerUser(UserDto userDto) {
        UserDto outUserDto = userService.createUser(userDto);
            return userAssembler.toModel(outUserDto);
    }

    public AuthResponse auth(AuthRequest request) {
        User user = UserMapper.INSTANCE.toUser(userService.findByLoginAndPassword(request.getLogin(), request.getPassword()));
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponse(token);
    }
}
