package com.rostikandrusiv.epamlab29.spring.mvc.rest.repository;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Session;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Optional<Session> findById(int id);

}
