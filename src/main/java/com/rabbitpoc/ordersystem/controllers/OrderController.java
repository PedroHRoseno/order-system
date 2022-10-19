package com.rabbitpoc.ordersystem.controllers;

import com.rabbitpoc.ordersystem.dtos.OrderDto;
import com.rabbitpoc.ordersystem.models.OrderModel;
import com.rabbitpoc.ordersystem.services.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/sending-orders")
    public ResponseEntity<OrderModel> sendingOrders(@RequestBody @Valid OrderDto orderDto){
        OrderModel orderModel = new OrderModel();
        BeanUtils.copyProperties(orderDto, orderModel);
        orderModel.setOrderDate(LocalDateTime.now());
        orderService.saveOrder(orderModel);
        return new ResponseEntity<>(orderModel, HttpStatus.CREATED);
    }
}
