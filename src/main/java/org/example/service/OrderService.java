package org.example.service;

import org.example.entity.OrderDetail;
import org.example.mapper.OrderMapper;
import org.example.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getOrdersBySupermarketId(Integer supermarketId) {
        return orderMapper.findOrdersBySupermarketId(supermarketId);
    }

    public List<OrderDetail> getOrderDetailsByOrderId(Integer orderId) {
        return orderMapper.findOrderDetailsByOrderId(orderId);
    }

    public void saveOrder(Order order) {
        orderMapper.insertOrder(order);
    }

    public void saveOrderDetail(OrderDetail orderDetail) {
        orderMapper.insertOrderDetail(orderDetail);
    }
}
