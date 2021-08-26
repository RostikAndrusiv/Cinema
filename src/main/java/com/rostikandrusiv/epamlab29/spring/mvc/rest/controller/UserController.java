package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.api.UserApi;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler.UserAssembler;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.UserModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler;

    public UserModel getUser(String login) {
        UserDto outUserDto = userService.getUser(login);
        return userAssembler.toModel(outUserDto);
    }

    public List<UserModel> getAllUsers() {
        List<UserDto> outAllUsersDto = userService.getAllUsers();
        return outAllUsersDto.stream()
                .map(userAssembler::toModel)
                .collect(Collectors.toList());
    }

    public UserModel createUser(UserDto userDto) {
        UserDto outUserDto = userService.createUser(userDto);
        return userAssembler.toModel(outUserDto);
    }

    public UserModel updateUser(String login, UserDto userDto) {
        UserDto outUserDto = userService.updateUser(login, userDto);
        return userAssembler.toModel(outUserDto);
    }


    public ResponseEntity<Void> deleteUser(String login) {
        userService.deleteUser(login);
        return ResponseEntity.noContent().build();
    }
}
