package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnCreate;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeanceDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotBlank(message = "MovieID should not be empty", groups = OnCreate.class)
    private MovieDto movie;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotBlank(message = "DateOfSeance should not be empty", groups = OnCreate.class)
    private LocalDate dateOfSeance;

    @NotBlank(message = "SessionId should not be empty", groups = OnCreate.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private SessionDto session;

    @NotBlank(message = "RoomId should not be empty", groups = OnCreate.class)
    private RoomDto room;

    @NotBlank(message = "Price should not be empty", groups = OnCreate.class)
    private double price;

    @JsonIgnoreProperties({"seance", "orders"})
    private List<Ticket> tickets;

}

