package com.rostikandrusiv.epamlab29.spring.mvc.rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private double duration;

    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private Collection<Seance> seances;
}
