
package com.example.inventory_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.inventory_management.service.ProductService;
import com.example.inventory_management.model.Product;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public Product add(@RequestBody Product entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product entity) {
        Optional<Product> optional = service.findById(id);
        if (optional.isPresent()) {
            Product existing = optional.get();

            return service.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable Long id) {
        return service.findById(id);
    }
}
