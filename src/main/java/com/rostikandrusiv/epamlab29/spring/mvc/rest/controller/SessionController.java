package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.api.SessionApi;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler.SessionAssembler;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.SessionModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SessionDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SessionController implements SessionApi {
    private final SessionService sessionService;
    private final SessionAssembler sessionAssembler;


    @Override
    public SessionModel getSession(long id) {
        SessionDto outSessionDto = sessionService.getSession(id);
        return sessionAssembler.toModel(outSessionDto);
    }

    public List<SessionModel> getAllSessions() {
        List<SessionDto> outAllSessionDtos = sessionService.getAllSessions();
        return outAllSessionDtos.stream()
                .map(sessionAssembler::toModel)
                .collect(Collectors.toList());
    }


    public SessionModel createSession(SessionDto sessionDto) {
        SessionDto outSessionDto = sessionService.createSession(sessionDto);
        return sessionAssembler.toModel(outSessionDto);
    }

    public SessionModel updateSession(long id, SessionDto sessionDto) {
        SessionDto outSessionDto = sessionService.updateSession(id, sessionDto);
        return sessionAssembler.toModel(outSessionDto);
    }


    public ResponseEntity<Void> deleteSession(long id) {
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }

}
