package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation.TimeAfter;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation.TimeBefore;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnCreate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDto {

    private long id;

    @TimeAfter(value = "09:00", groups = OnCreate.class)
    @TimeBefore(value = "22:00", groups = OnCreate.class)
    private LocalTime startTime;
}
