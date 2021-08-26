package com.rostikandrusiv.epamlab29.spring.mvc.rest.service;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUser(String login);

    List<UserDto> getAllUsers();

    UserDto createUser(UserDto userDto);

    UserDto findByLoginAndPassword(String login, String password);

    UserDto updateUser(String login, UserDto userDto);

    void deleteUser(String login);

}
