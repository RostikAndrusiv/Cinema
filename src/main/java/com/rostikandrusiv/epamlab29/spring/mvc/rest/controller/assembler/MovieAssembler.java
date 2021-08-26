package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.MovieController;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.MovieModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.MovieDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MovieAssembler extends RepresentationModelAssemblerSupport<MovieDto, MovieModel> {

    public static final String GET_REL = "get_movie";
    public static final String GET_ALL_REL = "get_all_movies";
    public static final String CREATE_REL = "create_movie";
    public static final String UPDATE_REL = "update_movie";
    public static final String DELETE_REL = "delete_movie";

    public MovieAssembler() {
        super(MovieController.class, MovieModel.class);
    }

    @Override
    public MovieModel toModel(MovieDto entity) {

        MovieModel movieModel = new MovieModel(entity);

        Link get = linkTo(methodOn(MovieController.class).getMovie(entity.getId())).withRel(GET_REL);

        Link getAll = linkTo(methodOn(MovieController.class).getAllMovies()).withRel(GET_ALL_REL);

        Link create = linkTo(methodOn(MovieController.class).createMovie(entity)).withRel(CREATE_REL);

        Link update = linkTo(methodOn(MovieController.class).updateMovie(entity.getId(), entity))
                .withRel(UPDATE_REL);
        Link delete = linkTo(methodOn(MovieController.class).deleteMovie(entity.getId()))
                .withRel(DELETE_REL);

        movieModel.add(get, getAll, create, update, delete);

        return movieModel;
    }


}
