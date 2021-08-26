package com.rostikandrusiv.epamlab29.spring.mvc.rest.service.impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.OrderDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.TicketOrder;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.OrderService;

import java.util.List;
import java.util.Set;

public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDto createOrder(Set<TicketOrder> ticketOrders) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return null;
    }

    @Override
    public List<OrderDto> getCurrentUserOrders() {
        return null;
    }

    @Override
    public List<OrderDto> getUserOrders(long userId) {
        return null;
    }
}
