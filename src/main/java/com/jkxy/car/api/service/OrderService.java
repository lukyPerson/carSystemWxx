package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.OrderTable;

import java.util.List;

public interface OrderService {
    OrderTable getOrderById(int orderId);

    List<OrderTable> getOrderByUserId(String userId);
    void insertOrder(OrderTable order);
    Integer updateOrderById(OrderTable orderTable);
    void deleteOrder(OrderTable orderTable);
}
