package com.rostikandrusiv.epamlab29.spring.mvc.rest.api;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.UserModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnCreate;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "User management API")
@RequestMapping("/api/v1/users")
public interface UserApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Get user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{login}")
    UserModel getUser(@PathVariable String login);

    @ApiOperation("Get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<UserModel> getAllUsers();

    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Update user")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{login}")
    UserModel updateUser(@PathVariable @Validated(OnUpdate.class) String login, @RequestBody UserDto userDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Delete user")
    @DeleteMapping(value = "/{login}")
    ResponseEntity<Void> deleteUser(@PathVariable String login);
}
