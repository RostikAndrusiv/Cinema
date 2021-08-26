package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.MovieDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Movie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDto toMovieDto(Movie movie);

    @InheritInverseConfiguration
    Movie toMovie(MovieDto movieDto);
}
