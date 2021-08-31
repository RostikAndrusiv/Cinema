package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.Impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.SeanceMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SeanceMapperImpl implements SeanceMapper {

    private ModelMapper mapper;

    @Autowired
    public SeanceMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Seance toSeance(SeanceDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Seance.class);
    }

    @Override
    public SeanceDto toSeanceDto(Seance entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, SeanceDto.class);
    }
}
