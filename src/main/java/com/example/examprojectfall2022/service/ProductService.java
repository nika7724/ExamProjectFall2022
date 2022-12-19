package com.example.examprojectfall2022.service;

import com.example.examprojectfall2022.model.Product;
import com.example.examprojectfall2022.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    //constructor injection
    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //get all Product
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    //find product by Id
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    //create product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    //delete product
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    //edit product
    public Product editProduct(Long id, Product newProduct) {
        if (productRepository.findById(id).isEmpty())
            return null;
        {
            return productRepository.save(newProduct);
        }
    }
}
