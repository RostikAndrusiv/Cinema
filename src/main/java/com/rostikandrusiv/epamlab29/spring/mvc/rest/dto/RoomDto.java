package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
@Builder
public class RoomDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String name;

    private int numberOfSeats;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<SeatDto> seats;

}