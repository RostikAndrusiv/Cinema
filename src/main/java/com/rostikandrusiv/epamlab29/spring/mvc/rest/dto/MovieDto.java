package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import lombok.Data;

@Data
public class MovieDto {

    private long id;

    private String name;

    private double duration;

    private String description;
}
