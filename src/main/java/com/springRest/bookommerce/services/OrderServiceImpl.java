package com.springRest.bookommerce.services;

import com.springRest.bookommerce.model.OrderModel;
import com.springRest.bookommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public String placeOrder(OrderModel orderModel) {
        orderRepository.save(orderModel);
        return "Order Added Successful!";
    }

    @Override
    public List<OrderModel> getOrderList() {
        return orderRepository.findAll();
    }
}
