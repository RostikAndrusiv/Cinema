package com.rostikandrusiv.epamlab29.spring.mvc.rest.service;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUser(long id);

    List<UserDto> getAllUsers();

    UserDto createUser(UserDto userDto);

    UserDto findByLoginAndPassword(String login, String password);

    UserDto updateUser(long id, UserDto userDto);

    void deleteUser(long id);


}
