package com.example.examprojectfall2022.service;

import com.example.examprojectfall2022.model.Product;
import com.example.examprojectfall2022.model.ProductDescription;
import com.example.examprojectfall2022.repository.ProductDescriptionRespository;
import com.example.examprojectfall2022.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)//use the mockito annotation
class ProductServiceTest {

    // inject a mock for an instance variable that we can use anywhere in the test class
    @Mock
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductDescriptionService productDescriptionService;
    @Mock
    private ProductDescriptionRespository productDescriptionRespository;

    private Long id;
    private Product product;
    private Long productDescriptionId;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository, productDescriptionService);
        ProductDescription productDescription1 = new ProductDescription("Vegetable");
        product = new Product("Onion", 15, 500, productDescription1);
    }

    @Test
    void getAllProduct() {
        productService.getAllProducts();
        Mockito.verify(productRepository).findAll();
    }

    @Test
    void getProductById() {
        productService.getProductById(id);
        Mockito.verify(productRepository).findById(id);
    }

    @Test
    void createProduct() {
        productService.createProduct(product, productDescriptionId);
        ArgumentCaptor<Product> ProductArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(ProductArgumentCaptor.capture());
        Product capturedProduct = ProductArgumentCaptor.getValue();
        assertThat(capturedProduct).isEqualTo(product);
    }

    @Test
    void deleteProductById() {
        productService.deleteProductById(id);
        Mockito.verify(productRepository).deleteById(id);
    }

    @Test
    void editProduct() {
        //given precondition or setup
        product.setProductName("onion");
        product.setPrice(15);
        product.setWeight(500);


        Mockito.when(productRepository.findById(id)).thenReturn(Optional.ofNullable(product));
        Mockito.when(productRepository.save(product)).thenReturn(product);
//action or the behaviour that we are going to test
        Product editProduct = productService.editProduct(id, product);

//verify the output
        assertThat(editProduct.getProductName()).isEqualTo("onion");
        assertThat(editProduct.getPrice()).isEqualTo(15);
        assertThat(editProduct.getWeight()).isEqualTo(500);
    }

}
