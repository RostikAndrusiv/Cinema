package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;
    private String name;
    private double duration;
    private String description;
}
