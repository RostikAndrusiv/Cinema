package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seat;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    private String name;

    private int numberOfSeats;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<SeatDto> seats;

}