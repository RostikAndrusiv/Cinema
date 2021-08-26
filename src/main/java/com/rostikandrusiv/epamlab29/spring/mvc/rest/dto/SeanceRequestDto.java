package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnCreate;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeanceRequestDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotNull(message = "MovieID should not be empty", groups = OnCreate.class)
    private int movieId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "DateOfSeance should not be empty", groups = OnCreate.class)
    private Date dateOfSeance;

    @NotNull(message = "SessionId should not be empty", groups = OnCreate.class)
    private int sessionId;

    @NotNull(message = "RoomId should not be empty", groups = OnCreate.class)
    private int roomId;

    @NotNull(message = "Price should not be empty", groups = OnCreate.class)
    private double price;
}
