package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.OrderMapper;
import com.jkxy.car.api.pojo.OrderTable;
import com.jkxy.car.api.pojo.Stock;
import com.jkxy.car.api.service.OrderService;
import com.jkxy.car.api.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public OrderTable getOrderById(int orderId) {
        return orderMapper.getOrder(orderId).get(0);
    }

    @Override
    public List<OrderTable> getOrderByUserId(String userId) {
        return orderMapper.getOrderByUserId(userId);
    }


    @Override
    public void insertOrder(OrderTable order) {
        orderMapper.insertOrder(order);
    }

    @Override
    public Integer updateOrderById(OrderTable orderTable) {
        return null;
    }

    @Override
    public void deleteOrder(OrderTable orderTable) {

    }
}
