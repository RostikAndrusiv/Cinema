package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation.TimeAfter;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.annotation.TimeBefore;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnCreate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.LocalTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

//    @Pattern(regexp = "^((0[9]|1[0-9]|2[0-1]):[0-5][0-9])|(22:00)$", message = "Time must be between 09:00 and 22:00", groups = OnCreate.class)
    @TimeAfter(value = "09:00", groups = OnCreate.class)
    @TimeBefore(value = "22:00", groups = OnCreate.class)
    private LocalTime startTime;
}
