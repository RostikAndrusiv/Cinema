package com.rostikandrusiv.epamlab29.spring.mvc.rest.repository;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
