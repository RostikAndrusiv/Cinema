package com.rostikandrusiv.epamlab29.spring.mvc.rest.service;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SessionDto;

import java.util.List;

public interface SessionService {

    SessionDto getSession(long id);

    SessionDto createSession(SessionDto sessionDto);

    SessionDto updateSession(long id, SessionDto sessionDto);

    void deleteSession(long id);

    List<SessionDto> getAllSessions();
}
