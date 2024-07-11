
package com.example.inventory_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inventory_management.repository.UserRepository;
import com.example.inventory_management.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User save(User entity) {
        return repository.save(entity);
    }

    public User update(Long id, User entity) {
        return repository.findById(id).map(existing -> {
            existing.setUsername(entity.getUsername());
            existing.setPassword(entity.getPassword());
            existing.setRole(entity.getRole());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
