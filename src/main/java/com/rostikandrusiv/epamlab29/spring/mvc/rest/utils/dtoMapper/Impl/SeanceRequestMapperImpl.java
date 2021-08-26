package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.Impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceRequestDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.exception.MovieNotFoundException;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.exception.RoomNotFoundException;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.exception.SessionNotFoundException;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.MovieRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.RoomRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.SessionRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.SeanceRequestMapper;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeanceRequestMapperImpl implements SeanceRequestMapper {

    private final ModelMapper mapper;

    private final SessionRepository sessionRepository;

    private final MovieRepository movieRepository;

    private final RoomRepository roomRepository;

    public SeanceRequestMapperImpl(ModelMapper mapper, SessionRepository sessionRepository, MovieRepository movieRepository, RoomRepository roomRepository) {
        this.mapper = mapper;
        this.sessionRepository = sessionRepository;
        this.movieRepository = movieRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Seance toSeance(SeanceRequestDto dto) {
        return mapper.map(dto, Seance.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(SeanceRequestDto.class, Seance.class)
                .addMappings(m -> m.skip(Seance::setMovie)).setPostConverter(toEntityConverter())
                .addMappings(m -> m.skip(Seance::setSession)).setPostConverter(toEntityConverter())
                .addMappings(m -> m.skip(Seance::setRoom)).setPostConverter(toEntityConverter());
    }

    public Converter<SeanceRequestDto, Seance> toEntityConverter() {
        return context -> {
            SeanceRequestDto source = context.getSource();
            Seance destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    void mapSpecificFields(SeanceRequestDto source, Seance destination) {
        destination.setSession(sessionRepository.findById(source.getSessionId())
                .orElseThrow(SessionNotFoundException::new));
        destination.setMovie(movieRepository.findById(source.getMovieId())
                .orElseThrow(MovieNotFoundException::new));
        destination.setRoom(roomRepository.findById(source.getRoomId())
                .orElseThrow(RoomNotFoundException::new));
    }
}
