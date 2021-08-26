package com.rostikandrusiv.epamlab29.spring.mvc.rest.api;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.SeanceModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceRequestDto;
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

@Api(tags = "Seance management API")
@RequestMapping("/api/v1/seance")
public interface SeanceApi {


    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Seance id"),
    })
    @ApiOperation("get Seance")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    SeanceModel getSeance(@PathVariable long id);

    @ApiOperation("Get all Seances")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<SeanceModel> getAllSeances();

    @ApiOperation("Create Seance")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    SeanceModel createSeance(@RequestBody @Validated(OnCreate.class) SeanceRequestDto seanceRequestDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Seance id"),
    })
    @ApiOperation("Update Seance")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    SeanceModel updateSeance(@PathVariable @Validated(OnUpdate.class) long id, @RequestBody SeanceDto seanceDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Seance id"),
    })
    @ApiOperation("Delete Seance")
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteSeance(@PathVariable long id);
}

