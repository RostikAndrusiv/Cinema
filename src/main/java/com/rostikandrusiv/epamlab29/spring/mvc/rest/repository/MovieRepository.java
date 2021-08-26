package com.rostikandrusiv.epamlab29.spring.mvc.rest.repository;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByName(String movieName);

    Optional<Movie> findById(int id);

}
