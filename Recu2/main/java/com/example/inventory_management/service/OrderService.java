
package com.example.inventory_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inventory_management.repository.OrderRepository;
import com.example.inventory_management.model.Order;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    public Order save(Order entity) {
        return repository.save(entity);
    }

    public Order update(Long id, Order entity) {
        return repository.findById(id).map(existing -> {
            existing.setUser(entity.getUser());
            existing.setProduct(entity.getProduct());
            existing.setQuantity(entity.getQuantity());
            existing.setStatus(entity.getStatus());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
