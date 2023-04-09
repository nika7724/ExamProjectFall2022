package com.example.examprojectfall2022.repository;

import com.example.examprojectfall2022.model.Product;
import com.example.examprojectfall2022.model.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//dropdown
    List<Product> findAllByProductDescription(ProductDescription productDescription);

    //search by keyword
    @Query("SELECT p FROM Product p WHERE p.productName LIKE '%?1%'")
    List <Product> findByKeyword(String keyword);

    Product findByProductName(String productName);

}
