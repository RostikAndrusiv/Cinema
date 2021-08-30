package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.SeanceController;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.SeanceModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SeanceAssembler extends RepresentationModelAssemblerSupport<SeanceDto, SeanceModel> {

    public static final String GET_REL = "get_seance";
    public static final String GET_ALL_REL = "get_all_seance";
    public static final String CREATE_REL = "create_seance";
    public static final String UPDATE_REL = "update_seance";
    public static final String DELETE_REL = "delete_seance";

    public SeanceAssembler() {
        super(SeanceController.class, SeanceModel.class);
    }

    @Override
    public SeanceModel toModel(SeanceDto entity) {
        SeanceModel seanceModel = new SeanceModel(entity);

        Link get = linkTo(methodOn(SeanceController.class).getSeance(entity.getId())).withRel(GET_REL);

        Link getAll = linkTo(methodOn(SeanceController.class).getAllSeances()).withRel(GET_ALL_REL);

        Link create = linkTo(methodOn(SeanceController.class).createSeance(null)).withRel(CREATE_REL);

        Link update = linkTo(methodOn(SeanceController.class).updateSeance(entity.getId(), entity))
                .withRel(UPDATE_REL);
        Link delete = linkTo(methodOn(SeanceController.class).deleteSeance(entity.getId()))
                .withRel(DELETE_REL);

        seanceModel.add(get, create, getAll, update, delete);

        return seanceModel;


    }
}
