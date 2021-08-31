package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.Impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeatDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seat;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.SeatMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SeatMapperImpl implements SeatMapper {

    private ModelMapper mapper;

    @Autowired
    public SeatMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Seat toSeat(SeatDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Seat.class);
    }

    @Override
    public SeatDto toSeatDto(Seat entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, SeatDto.class);
    }
}
