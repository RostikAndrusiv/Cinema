package com.rostikandrusiv.epamlab29.spring.mvc.rest.api;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.MovieModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.MovieDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnCreate;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Movie management API")
@RequestMapping("/api/v1/movies")
public interface MovieApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Movie name"),
    })
    @ApiOperation("Get movie")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}")
    MovieModel getMovie(@PathVariable long id);

    @ApiOperation("Get all movies")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<MovieModel> getAllMovies();

    @ApiOperation("Create movie")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    MovieModel createMovie(@RequestBody @Validated(OnCreate.class) MovieDto movieDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Movie name"),
    })
    @ApiOperation("Update movie")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    MovieModel updateMovie(@PathVariable @Validated(OnUpdate.class) long id, @RequestBody MovieDto movieDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Movie name"),
    })
    @ApiOperation("Delete movie")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable long id);
}

