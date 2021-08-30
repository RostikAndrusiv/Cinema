package com.rostikandrusiv.epamlab29.spring.mvc.rest.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
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
    private Seance seance;
    @JsonIgnoreProperties("ticket")
    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Order orders;

    private boolean booked;

}
