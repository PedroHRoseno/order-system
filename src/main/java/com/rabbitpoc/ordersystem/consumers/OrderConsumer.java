package com.rabbitpoc.ordersystem.consumers;

import com.rabbitpoc.ordersystem.dtos.OrderDto;
import com.rabbitpoc.ordersystem.models.OrderModel;
import com.rabbitpoc.ordersystem.services.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Component
public class OrderConsumer {

    @Autowired
    OrderService orderService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload OrderDto orderDto){
        OrderModel orderModel = new OrderModel();
        BeanUtils.copyProperties(orderDto, orderModel);
        orderModel.setOrderDate(LocalDateTime.now());
        orderService.saveOrder(orderModel);
        System.out.println("Order received: " + orderModel.getOrderName());
    }
}
