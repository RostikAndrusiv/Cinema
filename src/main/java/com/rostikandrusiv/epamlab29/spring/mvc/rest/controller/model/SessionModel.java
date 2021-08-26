package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SessionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
public class SessionModel extends RepresentationModel<SessionModel> {

    @JsonUnwrapped
    private SessionDto sessionDto;
}
