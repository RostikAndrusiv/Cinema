package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.OrderDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.OrderRequest;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/reserve")
    public OrderDto reserveTickets(@RequestBody OrderRequest orderRequest){
        OrderDto reserved = orderService.reserveTickets(orderRequest);
        return reserved;
    }

    @GetMapping("/api/v1/orders")
    public List<OrderDto> getAllOrders(){
        List<OrderDto> outAllUsersDto = orderService.getAllOrders();
        return orderService.getAllOrders();
    }
}
