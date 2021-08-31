package com.rostikandrusiv.epamlab29.spring.mvc.rest.service.impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.MovieDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.exception.MovieNotFoundException;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Movie;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.MovieRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.MovieService;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDto getMovie(long id) {
        log.info("getMovie by id {} ", id);
        Movie movie = movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
        return movieMapper.toMovieDto(movie);
    }

    @Override
    public List<MovieDto> getAllMovies() {
        log.info("getAllMovies");
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movieMapper::toMovieDto)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        log.info("createMovie with name {} ", movieDto.getName());
        Movie movie = movieMapper.toMovie(movieDto);
        movie = movieRepository.save(movie);
        return movieMapper.toMovieDto(movie);
    }

    @Override
    public MovieDto updateMovie(long id, MovieDto movieDto) {
        log.info("updateMovie with id {} ", id);
        Movie persistedMovie = movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
        Movie storedMovie = movieRepository.save(persistedMovie);
        log.info("Movie with id {} was successfully updated", storedMovie.getId());
        return movieMapper.toMovieDto(persistedMovie);
    }

    @Override
    public void deleteMovie(long id) {
        log.info("deleteMovie with id {} ", id);
        Movie movie = movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
        movieRepository.delete(movie);
    }
}
