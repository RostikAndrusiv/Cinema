package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Room;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import lombok.Builder;
import lombok.Data;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class SeatDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    int id;

    int number;

//    private Collection<Ticket> tickets;
//
//    private Room room;

}
