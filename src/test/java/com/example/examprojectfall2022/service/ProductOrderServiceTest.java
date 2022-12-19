package com.example.examprojectfall2022.service;

import com.example.examprojectfall2022.model.Delivery;
import com.example.examprojectfall2022.model.Product;
import com.example.examprojectfall2022.model.ProductOrder;
import com.example.examprojectfall2022.repository.ProductOrderRepository;
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

@ExtendWith(MockitoExtension.class)//use Mockito
class ProductOrderServiceTest {

    @Mock
    private ProductOrderService productOrderService;
    @Mock
    private ProductOrderRepository productOrderRepository;
    @Mock
    private ProductService productService;
    @Mock
    private DeliveryService deliveryService;

    private Long id;
    private ProductOrder productOrder;
    private Long productId;
    private Long deliveryId;

    @BeforeEach //should be executed before each test method
    void setUp() {
productOrderService = new ProductOrderService(productOrderRepository,
        productService, deliveryService);
        Product product = new Product("onion", 15, 500);
        Delivery delivery = new Delivery(LocalDate.of(2022,12,25),
                "warehouse1", "CopenhagenE");
        productOrder = new ProductOrder(3, product, delivery);
    }

    @Test
    void getAllProductOrder() {
        productOrderService.getAllProductOrders();
        Mockito.verify(productOrderRepository).findAll();
    }

    @Test
    void getProductOrderById() {
        productOrderService.getProductOrderById(id);
        Mockito.verify(productOrderRepository).findById(id);
    }

    @Test
    void createProductOrder() {
        productOrderService.createProductOrder(productOrder, productId, deliveryId);
        ArgumentCaptor<ProductOrder> ProductOrderArgumentCaptor = ArgumentCaptor.forClass(ProductOrder.class);
        verify(productOrderRepository).save(ProductOrderArgumentCaptor.capture());
        ProductOrder capturedProductOrder = ProductOrderArgumentCaptor.getValue();
        assertThat(capturedProductOrder).isEqualTo(productOrder);
    }

    @Test
    void deleteProductOrder() {
        productOrderService.deleteProductOrder(id);
        Mockito.verify(productOrderRepository).deleteById(id);
    }

    @Test
    void editProductOrder() {
        //given precondition or setup
        productOrder.setQuantity(12);
        Mockito.when(productOrderRepository.findById(id)).thenReturn(Optional.ofNullable(productOrder));
        Mockito.when(productOrderRepository.save(productOrder)).thenReturn(productOrder);
//action or the behaviour that we are going to test
        ProductOrder editProductOrder = productOrderService.editProductOrder(id, productOrder);
//verify the output
        assertThat(editProductOrder.getQuantity()).isEqualTo(12);
    }
}