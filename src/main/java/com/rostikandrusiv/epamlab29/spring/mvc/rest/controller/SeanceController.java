package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.api.SeanceApi;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler.SeanceAssembler;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.SeanceModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SeanceRequestDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.SeanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SeanceController implements SeanceApi {
    private final SeanceService seanceService;
    private final SeanceAssembler seanceAssembler;


    @Override
    public SeanceModel getSeance(long id) {
        SeanceDto outSeanceDto = seanceService.getSeance(id);
        return seanceAssembler.toModel(outSeanceDto);
    }

    public List<SeanceModel> getAllSeances() {
        List<SeanceDto> outAllSeanceDtos = seanceService.getAllSeances();
        return outAllSeanceDtos.stream()
                .map(seanceAssembler::toModel)
                .collect(Collectors.toList());
    }

    public SeanceModel createSeance(SeanceRequestDto seanceRequestDto) {
        SeanceDto outSeanceDto = seanceService.createSeance(seanceRequestDto);
        return seanceAssembler.toModel(outSeanceDto);
    }

    public SeanceModel updateSeance(long id, SeanceDto seanceDto) {
        SeanceDto outSeanceDto = seanceService.updateSeance(id, seanceDto);
        return seanceAssembler.toModel(outSeanceDto);
    }

    public ResponseEntity<Void> deleteSeance(long id) {
        seanceService.deleteSeance(id);
        return ResponseEntity.noContent().build();
    }
}
