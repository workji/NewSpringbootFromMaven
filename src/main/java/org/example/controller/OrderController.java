package org.example.controller;

import org.example.entity.Order;
import org.example.entity.OrderDetail;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{supermarketId}")
    public List<Order> getOrdersBySupermarketId(@PathVariable Integer supermarketId) {
        return orderService.getOrdersBySupermarketId(supermarketId);
    }

    @GetMapping("/details/{orderId}")
    public List<OrderDetail> getOrderDetailsByOrderId(@PathVariable Integer orderId) {
        return orderService.getOrderDetailsByOrderId(orderId);
    }

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @PostMapping("/detail")
    public void createOrderDetail(@RequestBody OrderDetail orderDetail) {
        orderService.saveOrderDetail(orderDetail);
    }
}
