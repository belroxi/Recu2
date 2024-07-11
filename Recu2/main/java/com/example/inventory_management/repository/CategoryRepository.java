
package com.example.inventory_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.inventory_management.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
