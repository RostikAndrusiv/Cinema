package com.rostikandrusiv.epamlab29.spring.mvc.rest.service;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.TicketDto;

import java.util.List;

public interface TicketService {

    TicketDto getTicket(long id);

    TicketDto createTicket(TicketDto ticketDto);

    void deleteTicket(long id);

    List<TicketDto> getAllTickets();
    
}
