package com.rostikandrusiv.epamlab29.spring.mvc.rest.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private double duration;

    private String description;

//    @JsonIgnore
//    @OneToMany(mappedBy = "movie")
//    @LazyCollection(LazyCollectionOption.FALSE)
//    private Collection<Seance> seances;
}
