package com.rostikandrusiv.epamlab29.spring.mvc.rest.service.impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.SessionDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.exception.SessionNotFoundException;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Session;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.SessionRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.SessionService;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.SessionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;

    @Override
    public SessionDto getSession(long id) {
        log.info("getSession by id {} ", id);
        Session session = sessionRepository.findById(id)
                .orElseThrow(SessionNotFoundException::new);
        return SessionMapper.INSTANCE.toSessionDto(session);
    }

    @Override
    public SessionDto createSession(SessionDto sessionDto) {
        log.info("createSession at {} ", sessionDto.getStartTime());
        Session session = SessionMapper.INSTANCE.toSession(sessionDto);
        session = sessionRepository.save(session);
        return SessionMapper.INSTANCE.toSessionDto(session);
    }

    @Override
    public SessionDto updateSession(long id, SessionDto sessionDto) {
        log.info("updateSession id= {}, startTime changed to {}", id, sessionDto.getStartTime());
        Session persistedSession = sessionRepository.findById(id)
                .orElseThrow(SessionNotFoundException::new);
        Session storedSession = sessionRepository.save(persistedSession);
        log.info("Session time was successfully changed to {}", storedSession.getStartTime());
        return SessionMapper.INSTANCE.toSessionDto(persistedSession);
    }

    @Override
    public void deleteSession(long id) {
        log.info("deleteSession id {} ", id);
        Session session = sessionRepository.findById(id)
                .orElseThrow(SessionNotFoundException::new);
        sessionRepository.delete(session);
    }

    @Override
    public List<SessionDto> getAllSessions() {
        log.info("getAllSessions");
        List<Session> sessions = sessionRepository.findAll();
        return sessions.stream()
                .map(SessionMapper.INSTANCE::toSessionDto)
                .collect(Collectors.toList());
    }
}