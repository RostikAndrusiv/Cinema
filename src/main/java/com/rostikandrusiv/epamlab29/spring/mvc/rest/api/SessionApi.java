package com.rostikandrusiv.epamlab29.spring.mvc.rest.api;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.SessionModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SessionDto;
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

@Api(tags = "Session management API")
@RequestMapping("/api/v1/session")
public interface SessionApi {


    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Session id"),
    })
    @ApiOperation("get session")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    SessionModel getSession(@PathVariable long id);

    @ApiOperation("Get all sessions")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<SessionModel> getAllSessions();

    @ApiOperation("Create session")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    SessionModel createSession(@RequestBody @Validated(OnCreate.class) SessionDto sessionDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Session id"),
    })
    @ApiOperation("Update session")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    SessionModel updateSession(@PathVariable @Validated(OnUpdate.class) long id, @RequestBody SessionDto sessionDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Session id"),
    })
    @ApiOperation("Delete session")
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteSession(@PathVariable long id);
}
