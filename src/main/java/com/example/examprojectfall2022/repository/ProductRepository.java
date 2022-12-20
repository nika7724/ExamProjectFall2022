package com.example.examprojectfall2022.repository;

import com.example.examprojectfall2022.model.Product;
import com.example.examprojectfall2022.model.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByProductDescription(ProductDescription productDescription);

}
