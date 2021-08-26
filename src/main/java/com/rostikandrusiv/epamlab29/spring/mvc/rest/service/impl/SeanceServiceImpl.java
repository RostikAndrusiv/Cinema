package com.rostikandrusiv.epamlab29.spring.mvc.rest.service.impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceRequestDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.exception.SeanceNotFoundException;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.SeanceRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.TicketRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.SeanceService;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.Impl.SeanceRequestMapperImpl;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.SeanceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository seanceRepository;
    private final TicketRepository ticketRepository;
    private final SeanceRequestMapperImpl seanceRequestMapper;

    @Override
    public SeanceDto getSeance(long id) {
        log.info("getSeance by id {} ", id);
        Seance seance = seanceRepository.findById(id)
                .orElseThrow(SeanceNotFoundException::new);
        return SeanceMapper.INSTANCE.toSeanceDto(seance);
    }

    @Override
    public SeanceDto createSeance(SeanceRequestDto seanceRequestDto) {
        log.info("createSeance");
        Seance seance = seanceRequestMapper.toSeance(seanceRequestDto);
        seance = seanceRepository.save(seance);
        final Seance toTicketSeance = seance;

        //initialize tickets for each seat in room after seance is created
        seance.getRoom().getSeats().forEach(seat->{
            Ticket ticket=new Ticket();
            ticket.setSeance(toTicketSeance);
            ticket.setSeat(seat);
            ticket.setBooked(false);
            ticketRepository.save(ticket);
        });
        return SeanceMapper.INSTANCE.toSeanceDto(seance);
    }

    @Override
    public SeanceDto updateSeance(long id, SeanceDto seanceDto) {
        log.info("updateSeance id= {}", id);
        Seance persistedSeance = seanceRepository.findById(id)
                .orElseThrow(SeanceNotFoundException::new);
        Seance storedSeance = seanceRepository.save(persistedSeance);
        log.info("Seance id = {} was successfully changed", storedSeance.getId());
        return SeanceMapper.INSTANCE.toSeanceDto(persistedSeance);
    }

    @Override
    public void deleteSeance(long id) {
        log.info("deleteSeance id {} ", id);
        Seance seance = seanceRepository.findById(id)
                .orElseThrow(SeanceNotFoundException::new);
        seanceRepository.delete(seance);
    }

    @Override
    public List<SeanceDto> getAllSeances() {
        log.info("getAllSeances");
        List<Seance> seances = seanceRepository.findAll();
        return seances.stream()
                .map(SeanceMapper.INSTANCE::toSeanceDto)
                .collect(Collectors.toList());
    }
}
