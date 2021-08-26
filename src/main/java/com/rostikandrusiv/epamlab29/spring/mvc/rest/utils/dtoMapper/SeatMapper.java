package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeatDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seat;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeatMapper {
    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);

    Seat toSeat(SeatDto seatDto);

    @InheritInverseConfiguration
    SeatDto toSeatDto(Seat seat);
}
