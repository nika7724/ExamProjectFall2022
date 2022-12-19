package com.example.examprojectfall2022.repository;

import com.example.examprojectfall2022.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
