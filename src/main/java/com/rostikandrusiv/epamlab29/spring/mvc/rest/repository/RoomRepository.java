package com.rostikandrusiv.epamlab29.spring.mvc.rest.repository;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Movie;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Room;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByName(String name);
    Optional<Room> findById(long id);
}
