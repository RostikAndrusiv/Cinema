package com.rostikandrusiv.epamlab29.spring.mvc.rest.model;

import lombok.Data;

import java.util.List;
@Data
public class OrderRequest {

    private List<Integer> ticketIdsList;
}
