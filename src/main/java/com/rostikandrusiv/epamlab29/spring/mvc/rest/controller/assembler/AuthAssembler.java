package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.AuthController;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.UserController;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.UserModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AuthAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public static final String REGISTER_REL = "Register";
    public static final String AUTH_REL = "Authorisation";

    public AuthAssembler() {
        super(AuthController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel authModel = new UserModel(entity);

        Link register = linkTo(methodOn(AuthController.class).registerUser(entity)).withRel(REGISTER_REL);

        Link auth = linkTo(methodOn(AuthController.class).auth(null)).withRel(AUTH_REL);

        authModel.add(register, auth);

        return authModel;
    }
}
