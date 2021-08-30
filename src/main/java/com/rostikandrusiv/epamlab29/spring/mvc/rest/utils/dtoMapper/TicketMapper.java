package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.TicketDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

//@Mapper(uses = {SeanceMapper.class, SeatMapper.class, OrderMapper.class})
@Mapper
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    @Mapping(target = "seance.tickets", ignore = true)
    TicketDto toTicketDto(Ticket ticket);

    @Mapping(target = "seance.tickets", ignore = true)
    @InheritInverseConfiguration
    Ticket toTicket(TicketDto ticketDto);

}
