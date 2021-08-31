package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.OrderDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.OrderDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Order;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface OrderMapper {

    Order toOrder(OrderDto dto);

    OrderDto toOrderDto(Order entity);

}
