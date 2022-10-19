package com.rabbitpoc.ordersystem.services;

import com.rabbitpoc.ordersystem.models.OrderModel;
import com.rabbitpoc.ordersystem.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void saveOrder(OrderModel orderModel) {
        orderRepository.save(orderModel);
    }
}
