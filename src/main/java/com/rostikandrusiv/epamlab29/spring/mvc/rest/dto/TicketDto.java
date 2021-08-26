package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Order;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seance;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seat;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDto {


    private long id;

    private Seance seance;

    private Seat seat;

    private Order orders;

    private boolean isBooked = false;

}
