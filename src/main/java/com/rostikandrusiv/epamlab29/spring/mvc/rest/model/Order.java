package com.rostikandrusiv.epamlab29.spring.mvc.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    @OneToMany(mappedBy = "orders")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double totalCost;
}
