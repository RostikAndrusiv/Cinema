package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;

public interface UserMapper {

    User toUser(UserDto dto);

    UserDto toUserDto(User entity);

}
