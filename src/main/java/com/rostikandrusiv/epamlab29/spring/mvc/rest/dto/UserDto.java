package com.rostikandrusiv.epamlab29.spring.mvc.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnCreate;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnUpdate;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    @NotBlank(message = "login should not be empty", groups = OnCreate.class)
    private String login;

    @Email
    @NotBlank(message = "email should not be empty", groups = OnCreate.class)
    @Null(message = "email should be empty in request", groups = OnUpdate.class)
    private String email;

    @Null(message = "password should be empty in request", groups = OnUpdate.class)
    @NotBlank(message = "Password should not be empty", groups = OnCreate.class)
    private String password;

    @Null(message = "repeatPassword should be empty in request", groups = OnUpdate.class)
    @NotBlank(message = "repeatPassword should not be empty", groups = OnCreate.class)
    private String repeatPassword;

}

