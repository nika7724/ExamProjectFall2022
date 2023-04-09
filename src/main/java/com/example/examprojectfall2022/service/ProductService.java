package com.example.examprojectfall2022.service;

import com.example.examprojectfall2022.model.Product;
import com.example.examprojectfall2022.model.ProductDescription;
import com.example.examprojectfall2022.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDescriptionService productDescriptionService;


    //constructor injection
    @Autowired
    public ProductService(final ProductRepository productRepository,
                          final ProductDescriptionService productDescriptionService) {
        this.productRepository = productRepository;
        this.productDescriptionService = productDescriptionService;
    }

    //get all Product
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //find product by Id
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /*//create product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }*/

    public Product createProduct(Product product, Long productDescriptionId) {
        ProductDescription productDescriptioion = productDescriptionService.getProductDescriptionById
                (productDescriptionId);
        product.setProductDescription(productDescriptioion);
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

    //find customer by keyword
    public Product search(String productName) {
        try{
            if (productName != null) {
                return productRepository.findByProductName(productName);
            }
        }catch (Exception e){
            System.out.println("not found the key"+ e);
        }
        return null;
    }
}
