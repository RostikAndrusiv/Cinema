package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.SessionController;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.SessionModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SessionDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
    public class SessionAssembler extends RepresentationModelAssemblerSupport<SessionDto, SessionModel> {

    public static final String GET_REL = "get_session";
    public static final String GET_ALL_REL = "get_all_sessions";
    public static final String CREATE_REL = "create_session";
    public static final String UPDATE_REL = "update_session";
    public static final String DELETE_REL = "delete_session";

    public SessionAssembler() {
        super(SessionController.class, SessionModel.class);
    }

    @Override
    public SessionModel toModel(SessionDto entity) {
        SessionModel sessionModel = new SessionModel(entity);

        Link get = linkTo(methodOn(SessionController.class).getAllSessions()).withRel(GET_REL);

        Link getAll = linkTo(methodOn(SessionController.class).getAllSessions()).withRel(GET_ALL_REL);

        Link create = linkTo(methodOn(SessionController.class).createSession(entity)).withRel(CREATE_REL);

        Link update = linkTo(methodOn(SessionController.class).updateSession(entity.getId(), entity))
                .withRel(UPDATE_REL);
        Link delete = linkTo(methodOn(SessionController.class).deleteSession(entity.getId()))
                .withRel(DELETE_REL);

        sessionModel.add(get, getAll, create, update, delete);

        return sessionModel;
    }
}
