package com.example.examprojectfall2022.repository;

import com.example.examprojectfall2022.model.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDescriptionRespository extends JpaRepository<ProductDescription, Long> {
}
