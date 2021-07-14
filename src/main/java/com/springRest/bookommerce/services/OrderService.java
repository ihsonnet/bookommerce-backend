package com.springRest.bookommerce.services;

import com.springRest.bookommerce.dto.ApiResponse;
import com.springRest.bookommerce.model.OrderModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<ApiResponse<OrderModel>> placeOrder(OrderModel orderModel);

    ResponseEntity<ApiResponse<List<OrderModel>>> getOrderList();
}
