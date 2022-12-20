package com.example.examprojectfall2022.service;

import com.example.examprojectfall2022.model.ProductDescription;
import com.example.examprojectfall2022.repository.ProductDescriptionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDescriptionService {
    private final ProductDescriptionRespository productDescriptionRespository;
    @Autowired
    public ProductDescriptionService(ProductDescriptionRespository productDescriptionRespository) {
        this.productDescriptionRespository = productDescriptionRespository;
    }

    //findAllProductDescription
    public List<ProductDescription> getAllProductDescription() {
        return productDescriptionRespository.findAll();
    }
    //findProductDescriptionById
    public ProductDescription getProductDescriptionById(Long id) {
        return productDescriptionRespository.findById(id).orElse(null);
    }

    //creat Product description
    public ProductDescription createProductDescription(ProductDescription productDescription) {
        return productDescriptionRespository.save(productDescription);
    }


}
