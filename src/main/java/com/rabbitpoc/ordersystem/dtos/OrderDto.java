package com.rabbitpoc.ordersystem.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class OrderDto {

    @NotBlank
    private String orderName;
    @NotBlank
    private String orderDescription;

}
