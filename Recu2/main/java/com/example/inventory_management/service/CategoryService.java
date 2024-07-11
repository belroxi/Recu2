
package com.example.inventory_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inventory_management.repository.CategoryRepository;
import com.example.inventory_management.model.Category;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    public Category save(Category entity) {
        return repository.save(entity);
    }

    public Category update(Long id, Category entity) {
        return repository.findById(id).map(existing -> {
            existing.setName(entity.getName());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
