package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnCreate;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeanceDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotBlank(message = "MovieID should not be empty", groups = OnCreate.class)
    private Movie movie;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotBlank(message = "DateOfSeance should not be empty", groups = OnCreate.class)

    private Date dateOfSeance;

    @NotBlank(message = "SessionId should not be empty", groups = OnCreate.class)
    private Session session;

    @NotBlank(message = "RoomId should not be empty", groups = OnCreate.class)
    private Room room;

    @NotBlank(message = "Price should not be empty", groups = OnCreate.class)
    private double price;


    private List<Ticket> tickets;

}

