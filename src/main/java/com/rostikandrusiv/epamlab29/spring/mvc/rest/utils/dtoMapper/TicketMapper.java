package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.TicketDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    TicketDto toTicketDto(Ticket ticket);

    @InheritInverseConfiguration
    Ticket toTicket(TicketDto ticketDto);
}
