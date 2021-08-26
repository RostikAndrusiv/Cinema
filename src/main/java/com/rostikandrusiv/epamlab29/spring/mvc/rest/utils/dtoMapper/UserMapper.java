package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


@Mapping(target = "repeatPassword", ignore=true)
@Mapping(target = "password", ignore = true)
UserDto toUserDto(User user);


    @InheritInverseConfiguration
   // @Mapping(target = "password", ignore = true)
    User toUser(UserDto userDto);
}