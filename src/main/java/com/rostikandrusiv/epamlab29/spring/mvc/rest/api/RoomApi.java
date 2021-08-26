package com.rostikandrusiv.epamlab29.spring.mvc.rest.api;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.RoomModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.RoomDto;
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

@Api(tags = "Room management API")
@RequestMapping("/api/v1/room")
public interface RoomApi {


    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Room id"),
    })
    @ApiOperation("get Room")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    RoomModel getRoom(@PathVariable long id);

    @ApiOperation("Get all Rooms")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<RoomModel> getAllRooms();

    @ApiOperation("Create Room")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    RoomModel createRoom(@RequestBody @Validated(OnCreate.class) RoomDto roomDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Room id"),
    })
    @ApiOperation("Update Room")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    RoomModel updateRoom(@PathVariable @Validated(OnUpdate.class) long id, @RequestBody RoomDto roomDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Room id"),
    })
    @ApiOperation("Delete Room")
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteRoom(@PathVariable long id);
}
