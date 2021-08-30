package com.rostikandrusiv.epamlab29.spring.mvc.rest.api;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.OrderModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.OrderRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Order management API")
@RequestMapping("/api/v1/orders")
public interface OrderApi {


    @ApiOperation("Create order")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/reserve")
    OrderModel reserveTickets(@RequestBody OrderRequest orderRequest);


    @ApiOperation("Get all orders")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<OrderModel> getAllOrders();

    @ApiOperation("Get current user orders")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/myOrders")
    List<OrderModel> getCurrentUserOrders();


    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "User id"),
    })
    @ApiOperation("Get orders by user id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{id}")
    List<OrderModel> getUserOrders(@PathVariable("id") long id);

}
