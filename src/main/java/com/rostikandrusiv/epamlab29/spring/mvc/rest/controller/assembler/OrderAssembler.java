package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.OrderController;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.OrderModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.OrderDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderAssembler extends RepresentationModelAssemblerSupport<OrderDto, OrderModel> {

    public static final String RESERVE_TICKETS_REL = "reserveTickets";
    public static final String GET_ALL_ORDERS_REL = "get_all_movies";
    public static final String GET_USER_ORDERS_REL = "create_movie";
    public static final String GET_CURRENT_USER_REL = "update_movie";

    public OrderAssembler() {
        super(OrderController.class, OrderModel.class);
    }

    @Override
    public OrderModel toModel(OrderDto entity) {

        OrderModel orderModel = new OrderModel(entity);

        Link post = linkTo(methodOn(OrderController.class).reserveTickets(null)).withRel(RESERVE_TICKETS_REL);

        Link getAll = linkTo(methodOn(OrderController.class).getAllOrders()).withRel(GET_ALL_ORDERS_REL);

        Link getSpecified = linkTo(methodOn(OrderController.class).getUserOrders(entity.getId())).withRel(GET_USER_ORDERS_REL);

        Link getCurrent = linkTo(methodOn(OrderController.class).getCurrentUserOrders()).withRel(GET_CURRENT_USER_REL);

        orderModel.add(post, getAll, getSpecified, getCurrent);

        return orderModel;
    }


}
