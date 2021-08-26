package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestSecurityController {

    private final UserService userService;

    @GetMapping("/admin/get/{login}")
    public UserDto getAdmin(@PathVariable String login) {
        return userService.getUser(login);
    }

//    @GetMapping("/user/get/{admin}")
//    public UserDto getUser(String login) {
//        UserDto outUserDto = userService.getUser(login);
//        return outUserDto;
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/users/get/{login}")
    public UserDto getUser(@PathVariable String login) {
        return userService.getUser(login);
    }
}
