
package com.example.inventory_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inventory_management.repository.ProductRepository;
import com.example.inventory_management.model.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public Product save(Product entity) {
        return repository.save(entity);
    }

    public Product update(Long id, Product entity) {
        return repository.findById(id).map(existing -> {
            existing.setName(entity.getName());
            existing.setDescription(entity.getDescription());
            existing.setPrice(entity.getPrice());
            existing.setCategory(entity.getCategory());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
