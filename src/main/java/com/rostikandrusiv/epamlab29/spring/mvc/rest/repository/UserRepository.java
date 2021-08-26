package com.rostikandrusiv.epamlab29.spring.mvc.rest.repository;


import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);




}
