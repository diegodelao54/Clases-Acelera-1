package com.enyoi.orders.controller;

import com.enyoi.orders.dto.CreateNewOrderCreatingNewClientDto;
import com.enyoi.orders.dto.GenerateNewOrderDto;
import com.enyoi.orders.model.Order;
import com.enyoi.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity<Order> createNewOrder(@RequestBody GenerateNewOrderDto dto){

        Order order = service.createNewOrder(dto); ;

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/client")
    public ResponseEntity<Order> createNewOrderNewClient( @RequestBody CreateNewOrderCreatingNewClientDto dto){

        Order order = service.creatingNewOrderCreatingNewClient(dto);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }


}
