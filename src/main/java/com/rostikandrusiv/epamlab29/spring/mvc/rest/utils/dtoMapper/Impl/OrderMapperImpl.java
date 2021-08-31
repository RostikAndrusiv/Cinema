package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.Impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.OrderDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Order;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.OrderMapper;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.Objects;

@Component
public class OrderMapperImpl implements OrderMapper {

    private ModelMapper mapper;

    @Autowired
    public OrderMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Order toOrder(OrderDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Order.class);
    }

    @Override
    public OrderDto toOrderDto(Order entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, OrderDto.class);
    }
}
