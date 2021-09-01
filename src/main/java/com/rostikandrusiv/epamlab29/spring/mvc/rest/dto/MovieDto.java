package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnCreate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDto {

    private long id;

    @NotBlank(message = "Movie name should not be empty", groups = OnCreate.class)
    private String name;

    private double duration;

    private String description;
}
