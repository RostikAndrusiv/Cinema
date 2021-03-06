package com.rostikandrusiv.epamlab29.spring.mvc.rest.repository;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from orders o where o.user.id = :userId")
    List<Order> findOrderByUser(long userId);


    @Query(value = "select sum(s.price) from Ticket t join Seance s on t.seance.id = s.id where t.orders.id = :orderId")
    Double findTotalCost(long orderId);

}
