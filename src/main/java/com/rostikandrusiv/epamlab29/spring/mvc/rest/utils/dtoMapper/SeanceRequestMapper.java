package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceRequestDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;

public interface SeanceRequestMapper {

    public Seance toSeance(SeanceRequestDto dto);

}
