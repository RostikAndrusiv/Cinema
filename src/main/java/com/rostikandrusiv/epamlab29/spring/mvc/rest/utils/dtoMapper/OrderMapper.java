package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.OrderDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);

    @InheritInverseConfiguration
    OrderDto toOrderDto(Order order);
}
