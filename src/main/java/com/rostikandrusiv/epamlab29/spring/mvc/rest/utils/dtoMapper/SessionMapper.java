package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SessionDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Session;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SessionMapper {
    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    SessionDto toSessionDto(Session session);

    @InheritInverseConfiguration
    Session toSession(SessionDto sessionDto);
}
