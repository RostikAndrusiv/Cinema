package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(uses = {MovieMapper.class, RoomMapper.class, SessionMapper.class,TicketMapper.class})
@Mapper
public interface SeanceMapper {
    SeanceMapper INSTANCE = Mappers.getMapper(SeanceMapper.class);
    @Mapping(target = "tickets.seance", expression = "java(null)")
    Seance toSeance(SeanceDto seanceDto);

    @InheritInverseConfiguration
    @Mapping(target = "tickets.seance", expression = "java(null)")
    SeanceDto toSeanceDto(Seance seance);
}
