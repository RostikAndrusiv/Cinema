package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.RoleDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role toRole(RoleDto roleDto);

    @InheritInverseConfiguration
    RoleDto toRoleDto(Role role);
}
