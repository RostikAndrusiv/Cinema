package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.UserRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.security.jwt.JwtProvider;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.UserService;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
   private JwtProvider jwtProvider;

    @PostMapping("/register")
    public UserDto registerUser(@RequestBody @Valid UserDto registrationRequest) {
        User user = new User();
        user.setPassword(registrationRequest.getPassword());
        user.setEmail(registrationRequest.getEmail());
        user.setLogin(registrationRequest.getLogin());
        userRepository.save(user);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = UserMapper.INSTANCE.toUser(userService.findByLoginAndPassword(request.getLogin(), request.getPassword()));
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponse(token);
    }
}
