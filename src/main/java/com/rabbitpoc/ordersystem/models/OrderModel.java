package com.rabbitpoc.ordersystem.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_ORDER")
public class OrderModel {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String orderName;
    private String orderDescription;
    private LocalDateTime orderDate;

}
