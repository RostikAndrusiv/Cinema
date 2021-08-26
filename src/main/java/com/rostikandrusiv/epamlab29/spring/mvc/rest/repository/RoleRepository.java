package com.rostikandrusiv.epamlab29.spring.mvc.rest.repository;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);
}
