package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.Impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SessionDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Session;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.SessionMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SessionMapperImpl implements SessionMapper {

    private ModelMapper mapper;

    @Autowired
    public SessionMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Session toSession(SessionDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Session.class);
    }

    @Override
    public SessionDto toSessionDto(Session entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, SessionDto.class);
    }
}
