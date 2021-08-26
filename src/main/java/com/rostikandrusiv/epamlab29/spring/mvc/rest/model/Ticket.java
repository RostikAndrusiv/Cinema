package com.rostikandrusiv.epamlab29.spring.mvc.rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JsonIgnore
    private Seance seance;

    @ManyToOne
    private Seat seat;

    @ManyToOne
    @JsonIgnore
    private Order orders;

    private boolean isBooked = false;

}
