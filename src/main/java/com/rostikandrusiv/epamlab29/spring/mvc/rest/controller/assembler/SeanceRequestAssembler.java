package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.SeanceController;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.SeanceRequestModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceRequestDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SeanceRequestAssembler extends RepresentationModelAssemblerSupport<SeanceRequestDto, SeanceRequestModel> {

    public static final String CREATE_REL = "create_seance";

    public SeanceRequestAssembler() {
        super(SeanceController.class, SeanceRequestModel.class);
    }

    @Override
    public SeanceRequestModel toModel(SeanceRequestDto entity) {

        SeanceRequestModel seanceRequestModel = new SeanceRequestModel(entity);

        Link create = linkTo(methodOn(SeanceController.class).createSeance(entity)).withRel(CREATE_REL);


        seanceRequestModel.add(create);

        return seanceRequestModel;


    }
}
