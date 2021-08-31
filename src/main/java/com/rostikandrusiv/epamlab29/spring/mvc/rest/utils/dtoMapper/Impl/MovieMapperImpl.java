package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.Impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.MovieDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Movie;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.MovieMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MovieMapperImpl implements MovieMapper {

    private ModelMapper mapper;

    @Autowired
    public MovieMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Movie toMovie(MovieDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Movie.class);
    }

    @Override
    public MovieDto toMovieDto(Movie entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, MovieDto.class);
    }
}