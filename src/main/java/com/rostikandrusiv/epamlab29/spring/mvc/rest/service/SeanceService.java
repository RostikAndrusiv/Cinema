package com.rostikandrusiv.epamlab29.spring.mvc.rest.service;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceRequestDto;

import java.util.List;

public interface SeanceService {

    SeanceDto getSeance(long id);

    List<SeanceDto> getAllSeances();

    SeanceDto createSeance(SeanceRequestDto seanceRequestDto);

    SeanceDto updateSeance(long id, SeanceDto seanceDto);

    void deleteSeance(long id);


}
