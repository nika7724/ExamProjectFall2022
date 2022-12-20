package com.example.examprojectfall2022.controller;

import com.example.examprojectfall2022.model.Product;
import com.example.examprojectfall2022.model.ProductDescription;
import com.example.examprojectfall2022.repository.ProductDescriptionRespository;
import com.example.examprojectfall2022.repository.ProductRepository;
import com.example.examprojectfall2022.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;
    private final ProductDescriptionRespository productDescriptionRespository;

    @Autowired
    public ProductController(final ProductService productService,
                             final ProductRepository productRepository,
                             ProductDescriptionRespository productDescriptionRespository) {
        this.productService = productService;
        this.productRepository = productRepository;
        this.productDescriptionRespository = productDescriptionRespository;
    }

    //return all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //find product by Id
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //create product
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product, @PathParam("productDescriptionId")Long productDescriptionId) {
        Product newProduct = productService.createProduct(product, productDescriptionId);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    //delete product
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
    productService.deleteProductById(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }

    //edit product
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> editProduct(@RequestBody Product newProduct,
                                               @PathVariable("id") Long id) {
    return new ResponseEntity<>(productService.editProduct(id, newProduct), HttpStatus.OK);
    }

    //for drop-down menu
    @PostMapping("/category/{id}")
    public List<Product> getProductDescription(@PathVariable("id")ProductDescription productDescription){
        return productRepository.findAllByProductDescription(productDescriptionRespository.findById(productDescription.getId()).get());
    }

}
