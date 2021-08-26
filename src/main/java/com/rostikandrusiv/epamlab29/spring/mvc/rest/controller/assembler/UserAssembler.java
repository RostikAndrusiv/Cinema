package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.UserController;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.UserModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public static final String GET_REL = "get_user";
    public static final String GET_ALL_REL = "get_all_users";
    public static final String CREATE_REL = "create_user";
    public static final String UPDATE_REL = "update_user";
    public static final String DELETE_REL = "delete_user";

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link get = linkTo(methodOn(UserController.class).getUser(entity.getLogin())).withRel(GET_REL);

        Link getAll = linkTo(methodOn(UserController.class).getAllUsers()).withRel(GET_ALL_REL);

        Link create = linkTo(methodOn(UserController.class).createUser(entity)).withRel(CREATE_REL);

        Link update = linkTo(methodOn(UserController.class).updateUser(entity.getLogin(), entity))
                .withRel(UPDATE_REL);
        Link delete = linkTo(methodOn(UserController.class).deleteUser(entity.getLogin()))
                .withRel(DELETE_REL);

        userModel.add(get, getAll, create, update, delete);

        return userModel;
    }
}
