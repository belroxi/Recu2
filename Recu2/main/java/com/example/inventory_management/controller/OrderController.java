
package com.example.inventory_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.inventory_management.service.OrderService;
import com.example.inventory_management.model.Order;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public Order add(@RequestBody Order entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order entity) {
        Optional<Order> optional = service.findById(id);
        if (optional.isPresent()) {
            Order existing = optional.get();

            return service.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Order> getById(@PathVariable Long id) {
        return service.findById(id);
    }
}
