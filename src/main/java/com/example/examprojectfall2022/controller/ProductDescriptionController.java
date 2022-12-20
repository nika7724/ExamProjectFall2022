package com.example.examprojectfall2022.controller;

import com.example.examprojectfall2022.model.ProductDescription;
import com.example.examprojectfall2022.service.ProductDescriptionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ProductDescriptionController {

    private final ProductDescriptionService productDescriptionService;

    public ProductDescriptionController(final ProductDescriptionService productDescriptionService) {
        this.productDescriptionService = productDescriptionService;
    }

    //getAll
    @GetMapping("/productdescriptions")
    public List<ProductDescription> getAllProductDescription() {
        return productDescriptionService.getAllProductDescription();
    }

}
