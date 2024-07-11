
package com.example.inventory_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.inventory_management.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
