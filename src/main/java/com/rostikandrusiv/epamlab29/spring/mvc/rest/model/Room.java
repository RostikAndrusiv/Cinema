package com.rostikandrusiv.epamlab29.spring.mvc.rest.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String name;

    private int numberOfSeats;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Seat> seats;

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private Collection<Seance> seances;
}
