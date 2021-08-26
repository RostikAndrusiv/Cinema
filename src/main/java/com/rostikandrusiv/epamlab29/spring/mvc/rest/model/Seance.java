package com.rostikandrusiv.epamlab29.spring.mvc.rest.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Movie movie;

    private Date dateOfSeance;


    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Session session;

    private double price;

    @ManyToOne
    private Room room;

    @OneToMany(mappedBy = "seance")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Ticket> tickets;
}
