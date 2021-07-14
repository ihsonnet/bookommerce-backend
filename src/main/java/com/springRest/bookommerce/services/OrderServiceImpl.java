package com.springRest.bookommerce.services;

import com.springRest.bookommerce.dto.ApiResponse;
import com.springRest.bookommerce.model.OrderModel;
import com.springRest.bookommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseEntity<ApiResponse<OrderModel>> placeOrder(OrderModel orderModel) {
        OrderModel order = orderRepository.save(orderModel);
        return new ResponseEntity<>(new ApiResponse<>(201,"Order Place Successful!",order), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse<List<OrderModel>>> getOrderList() {
        List<OrderModel> orderModelList = orderRepository.findAll();
        if (orderModelList.isEmpty()){
            return new ResponseEntity<>(new ApiResponse<>(200,"No Order Found!",null),HttpStatus.OK);
        }
         else {
            return new ResponseEntity<>(new ApiResponse<>(200,"Order Found!",orderModelList),HttpStatus.OK);
        }
    }
}
