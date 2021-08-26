package com.rostikandrusiv.epamlab29.spring.mvc.rest.service;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.MovieDto;

import java.util.List;


public interface MovieService {

    MovieDto getMovie(long id);

    List<MovieDto> getAllMovies();

    MovieDto createMovie(MovieDto movieDto);

    MovieDto updateMovie(long id, MovieDto movieDto);

    void deleteMovie(long id);
}
