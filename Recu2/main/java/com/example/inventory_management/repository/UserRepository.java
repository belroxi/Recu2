
package com.example.inventory_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.inventory_management.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
