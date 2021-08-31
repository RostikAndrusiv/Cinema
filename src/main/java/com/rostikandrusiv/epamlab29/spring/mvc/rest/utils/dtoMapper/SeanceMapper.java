package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;

public interface SeanceMapper {

    Seance toSeance(SeanceDto dto);

    SeanceDto toSeanceDto(Seance entity);

}
