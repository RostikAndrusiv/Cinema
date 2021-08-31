package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.*;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Order;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDto {

    private long id;

    @JsonIgnoreProperties("ticket")
    private SeatDto seat;

    private boolean booked;

    @JsonIgnoreProperties({"ticket","movie"})
    private SeanceDto seance;
}
