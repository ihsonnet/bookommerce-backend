package com.springRest.bookommerce.services;

import com.springRest.bookommerce.model.OrderModel;

import java.util.List;

public interface OrderService {
    String placeOrder(OrderModel orderModel);

    List<OrderModel> getOrderList();
}
