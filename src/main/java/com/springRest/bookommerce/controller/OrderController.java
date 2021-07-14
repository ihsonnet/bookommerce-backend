package com.springRest.bookommerce.controller;

import com.springRest.bookommerce.dto.ApiResponse;
import com.springRest.bookommerce.model.OrderModel;
import com.springRest.bookommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/user/order")
    public ResponseEntity<ApiResponse<OrderModel>> placeOrder(@RequestBody OrderModel orderModel){
       return orderService.placeOrder(orderModel);
    }

    @GetMapping("/admin/order")
    public ResponseEntity<ApiResponse<List<OrderModel>>> getOrderList(){
        return orderService.getOrderList();
    }
}
