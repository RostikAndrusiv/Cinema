package com.rostikandrusiv.epamlab29.spring.mvc.rest.service.impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.OrderDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Order;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.OrderRequest;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Ticket;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.OrderRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.TicketRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.UserRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.security.jwt.JwtUser;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.OrderService;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, TicketRepository ticketRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public OrderDto reserveTickets(OrderRequest orderRequest) {
        Order order = new Order();
        order.setTickets(new ArrayList<>());

        //get auth username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JwtUser jwtUser = (JwtUser) auth.getPrincipal();
        String userName = jwtUser.getUsername();

        orderRequest.getTicketIdsList().forEach(id -> {
            Ticket ticket = ticketRepository.findById(id);
            ticket.setBooked(true);
            ticket.setOrders(order);
            order.getTickets().add(ticket);
            order.setUser(userRepository.findByLogin(userName));
        });
        orderRepository.save(order);
        return OrderMapper.INSTANCE.toOrderDto(order);

    }

    @Override
    public List<OrderDto> getAllOrders() {
        log.info("getAllOrders");
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderMapper.INSTANCE::toOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getCurrentUserOrders() {
        log.info("getAllOrders from current user");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JwtUser jwtUser = (JwtUser) auth.getPrincipal();
        String userName = jwtUser.getUsername();
        List<Order> orders = orderRepository.findOrderByUser(userRepository.findByLogin(userName).getId());
        return orders.stream()
                .map(OrderMapper.INSTANCE::toOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getUserOrders(long id) {
        log.info("getAllOrders from user id {}", id);
        List<Order> orders = orderRepository.findOrderByUser(id);
        return orders.stream()
                .map(OrderMapper.INSTANCE::toOrderDto)
                .collect(Collectors.toList());
    }
}
