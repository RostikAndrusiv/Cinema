package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.RoomController;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.RoomModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.RoomDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RoomAssembler extends RepresentationModelAssemblerSupport<RoomDto, RoomModel> {

    public static final String GET_REL = "get_room";
    public static final String GET_ALL_REL = "get_all_room";
    public static final String CREATE_REL = "create_room";
    public static final String UPDATE_REL = "update_room";
    public static final String DELETE_REL = "delete_room";

    public RoomAssembler() {
        super(RoomController.class, RoomModel.class);
    }

    @Override
    public RoomModel toModel(RoomDto entity) {
        RoomModel roomModel = new RoomModel(entity);

        Link get = linkTo(methodOn(RoomController.class).getAllRooms()).withRel(GET_REL);

        Link getAll = linkTo(methodOn(RoomController.class).getAllRooms()).withRel(GET_ALL_REL);

        Link create = linkTo(methodOn(RoomController.class).createRoom(entity)).withRel(CREATE_REL);

        Link update = linkTo(methodOn(RoomController.class).updateRoom(entity.getId(), entity))
                .withRel(UPDATE_REL);
        Link delete = linkTo(methodOn(RoomController.class).deleteRoom(entity.getId()))
                .withRel(DELETE_REL);

        roomModel.add(get, getAll, create, update, delete);

        return roomModel;
    }
}
