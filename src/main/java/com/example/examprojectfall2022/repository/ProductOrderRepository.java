package com.example.examprojectfall2022.repository;

import com.example.examprojectfall2022.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
}
