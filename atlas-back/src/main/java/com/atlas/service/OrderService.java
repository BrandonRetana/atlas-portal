package com.atlas.service;

import com.atlas.repository.OrderRepository;
import com.atlas.models.taxonModels.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    
    @Transactional
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    
    @Transactional
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    
    @Transactional
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    public boolean isPresent(long id) {
        return orderRepository.existsById(id);
    }
    
}