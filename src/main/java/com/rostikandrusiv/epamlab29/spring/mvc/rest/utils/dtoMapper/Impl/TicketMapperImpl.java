package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.Impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.TicketDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.TicketMapper;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TicketMapperImpl implements TicketMapper {

    private ModelMapper mapper;

    @Autowired
    public TicketMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Ticket toTicket(TicketDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Ticket.class);
    }

    @Override
    public TicketDto toTicketDto(Ticket entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TicketDto.class);
    }
}