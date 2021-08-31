package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.Impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceRequestDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class UserMapperImpl implements UserMapper {

    private final ModelMapper mapper;

    @Autowired
    public UserMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User toUser(UserDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, User.class);

    }

    @Override
    public UserDto toUserDto(User entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, UserDto.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(User.class, UserDto.class)
                .addMappings(m -> m.skip(UserDto::setPassword))
                .addMappings(m -> m.skip(UserDto::setRepeatPassword));
    }
}
