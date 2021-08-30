package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnCreate;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnUpdate;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotBlank(message = "login should not be empty", groups = OnCreate.class)
    private String login;

    @Email
    @NotBlank(message = "email should not be empty", groups = OnCreate.class)
    @Null(message = "email should be empty in request", groups = OnUpdate.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;

    @Null(message = "password should be empty in request", groups = OnUpdate.class)
    @NotBlank(message = "Password should not be empty", groups = OnCreate.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Null(message = "repeatPassword should be empty in request", groups = OnUpdate.class)
    @NotBlank(message = "repeatPassword should not be empty", groups = OnCreate.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String repeatPassword;

}


