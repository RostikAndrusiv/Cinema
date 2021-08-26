package com.rostikandrusiv.epamlab29.spring.mvc.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

}
