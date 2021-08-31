package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.MovieDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.MovieDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Movie;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Movie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


public interface MovieMapper {

    Movie toMovie(MovieDto dto);

    MovieDto toMovieDto(Movie entity);

}
