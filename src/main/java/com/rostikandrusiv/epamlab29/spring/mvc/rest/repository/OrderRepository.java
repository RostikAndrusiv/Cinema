package com.rostikandrusiv.epamlab29.spring.mvc.rest.repository;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
