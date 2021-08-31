package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeatDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeatDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seat;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seat;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface SeatMapper {

    Seat toSeat(SeatDto dto);

    SeatDto toSeatDto(Seat entity);

}
