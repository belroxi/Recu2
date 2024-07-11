
package com.example.inventory_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.inventory_management.service.UserService;
import com.example.inventory_management.model.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public User add(@RequestBody User entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User entity) {
        Optional<User> optional = service.findById(id);
        if (optional.isPresent()) {
            User existing = optional.get();

            return service.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return service.findById(id);
    }
}
