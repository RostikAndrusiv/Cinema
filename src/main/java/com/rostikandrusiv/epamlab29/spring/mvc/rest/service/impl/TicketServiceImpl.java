package com.rostikandrusiv.epamlab29.spring.mvc.rest.service.impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.TicketDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.exception.TicketNotFoundException;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.TicketRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.TicketService;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public TicketDto getTicket(long id) {
        log.info("getTicket by id {} ", id);
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(TicketNotFoundException::new);
        return TicketMapper.INSTANCE.toTicketDto(ticket);
    }

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        log.info("createTicket id {} ", ticketDto.getId());
        Ticket ticket = TicketMapper.INSTANCE.toTicket(ticketDto);
        ticket = ticketRepository.save(ticket);
        return TicketMapper.INSTANCE.toTicketDto(ticket);
    }

    @Override
    public void deleteTicket(long id) {
        log.info("deleteTicket id {} ", id);
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(TicketNotFoundException::new);
        ticketRepository.delete(ticket);
    }

    @Override
    public List<TicketDto> getAllTickets() {
        log.info("getAllTickets");
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(TicketMapper.INSTANCE::toTicketDto)
                .collect(Collectors.toList());
    }


}
