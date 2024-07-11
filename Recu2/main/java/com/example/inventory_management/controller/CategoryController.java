
package com.example.inventory_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.inventory_management.service.CategoryService;
import com.example.inventory_management.model.Category;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping
    public Category add(@RequestBody Category entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category entity) {
        Optional<Category> optional = service.findById(id);
        if (optional.isPresent()) {
            Category existing = optional.get();

            return service.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Category> getById(@PathVariable Long id) {
        return service.findById(id);
    }
}
