package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.api.OrderApi;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler.OrderAssembler;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.OrderModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.OrderDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.OrderRequest;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final OrderService orderService;
    private final OrderAssembler orderAssembler;


    public List<OrderModel> getAllOrders() {
        List<OrderDto> outAllOrderDtos = orderService.getAllOrders();
        return outAllOrderDtos.stream()
                .map(orderAssembler::toModel)
                .collect(Collectors.toList());
    }

    public OrderModel reserveTickets(@RequestBody OrderRequest orderRequest){
        OrderDto reserved = orderService.reserveTickets(orderRequest);
        return orderAssembler.toModel(reserved);
    }

    public List<OrderModel> getCurrentUserOrders(){
        List<OrderDto> outCurrentUserOrdersDto = orderService.getCurrentUserOrders();
        return outCurrentUserOrdersDto.stream()
                .map(orderAssembler::toModel)
                .collect(Collectors.toList());
    }

    public List<OrderModel> getUserOrders(long id){
        List<OrderDto> outSpecifiedUserOrdersDto = orderService.getUserOrders(id);
        return outSpecifiedUserOrdersDto.stream()
                .map(orderAssembler::toModel)
                .collect(Collectors.toList());
    }

}
