package com.rostikandrusiv.epamlab29.spring.mvc.rest.service;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.OrderDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Order;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.TicketOrder;

import java.util.List;
import java.util.Set;

public interface OrderService {
    OrderDto createOrder(Set<TicketOrder> items);
    List<OrderDto> getAllOrders();
    List<OrderDto> getCurrentUserOrders();
    List<OrderDto> getUserOrders(long userId);
}
