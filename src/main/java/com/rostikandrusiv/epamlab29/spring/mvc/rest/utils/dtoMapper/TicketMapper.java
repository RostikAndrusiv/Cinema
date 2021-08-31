package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.TicketDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;

public interface TicketMapper {

  Ticket toTicket(TicketDto dto);

  TicketDto toTicketDto(Ticket entity);

}
