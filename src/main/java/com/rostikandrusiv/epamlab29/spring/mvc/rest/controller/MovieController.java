package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.api.MovieApi;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler.MovieAssembler;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.MovieModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.MovieDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MovieController implements MovieApi {

    private final MovieService movieService;
    private final MovieAssembler movieAssembler;

    public MovieModel getMovie(long id) {
        MovieDto outMovieDto = movieService.getMovie(id);
        return movieAssembler.toModel(outMovieDto);
    }

    public List<MovieModel> getAllMovies() {
        List<MovieDto> outAllMoviesDto = movieService.getAllMovies();
        return outAllMoviesDto.stream()
                .map(movieAssembler::toModel)
                .collect(Collectors.toList());
    }

    public MovieModel createMovie(MovieDto movieDto) {
        MovieDto outMovieDto = movieService.createMovie(movieDto);
        return movieAssembler.toModel(outMovieDto);
    }

    public MovieModel updateMovie(long id, MovieDto movieDto) {
        MovieDto outMovieDto = movieService.updateMovie(id, movieDto);
        return movieAssembler.toModel(outMovieDto);
    }


    public ResponseEntity<Void> deleteMovie(long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

}
