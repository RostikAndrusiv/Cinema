package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seat;
import lombok.*;

import java.util.Collection;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDto {

    private Long id;

    private String name;

    private int numberOfSeats;

//    private Collection<Seat> seats;
//
//    private Collection<Seance> seances;
}