package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeanceMapper {
    SeanceMapper INSTANCE = Mappers.getMapper(SeanceMapper.class);

    Seance toSeance(SeanceDto seanceDto);

    @InheritInverseConfiguration
    SeanceDto toSeanceDto(Seance seance);
}
