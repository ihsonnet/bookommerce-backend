package com.springRest.bookommerce.controller;

import com.springRest.bookommerce.model.OrderModel;
import com.springRest.bookommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public String placeOrder(@RequestBody OrderModel orderModel){
       return orderService.placeOrder(orderModel);
    }

    @GetMapping("/order")
    public List<OrderModel> getOrderList(){
        return orderService.getOrderList();
    }
}
