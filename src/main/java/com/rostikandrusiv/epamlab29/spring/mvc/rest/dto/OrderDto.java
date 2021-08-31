package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {

    private long id;

    @JsonIgnoreProperties({"login", "email", "password", "repeatPassword"})
    private UserDto user;

    @JsonIgnoreProperties({"orders", "seance"})
    private Collection<TicketDto> tickets;

    private double totalCost;
}
