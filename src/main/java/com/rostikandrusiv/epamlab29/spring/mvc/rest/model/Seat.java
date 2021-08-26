package com.rostikandrusiv.epamlab29.spring.mvc.rest.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int number;

    @JsonIgnore
    @OneToMany(mappedBy = "seat")
    private Collection<Ticket> tickets;


}
