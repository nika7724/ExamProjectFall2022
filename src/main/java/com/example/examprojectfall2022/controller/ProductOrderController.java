package com.example.examprojectfall2022.controller;

import com.example.examprojectfall2022.model.ProductOrder;
import com.example.examprojectfall2022.service.ProductOrderService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    @Autowired
    public ProductOrderController(final ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }


    @GetMapping("/productorders")
    public List<ProductOrder> getAllProductOrders() {
    return productOrderService.getAllProductOrders();
    }

    @GetMapping("/productorder/{id}")
    public ResponseEntity<ProductOrder> getProductOrderById(@PathVariable("id") Long id) {
        ProductOrder productOrder = productOrderService.getProductOrderById(id);
        return new ResponseEntity<>(productOrder, HttpStatus.OK);
    }

    @PostMapping("/productorder")
    public ResponseEntity<ProductOrder> createProductOrder(@RequestBody ProductOrder productOrder,
                                                           @PathParam("productId") Long productId,
                                                           @PathParam("deliveryId") Long deliveryId) {
    ProductOrder newProductOrder = productOrderService.createProductOrder
            (productOrder, productId, deliveryId);
    return new ResponseEntity<>(newProductOrder, HttpStatus.CREATED);
    }

    @DeleteMapping("/productorder/{id}")
    public ResponseEntity<?> deleteProductOrder(@PathVariable("id")Long id) {
    productOrderService.deleteProductOrder(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/productorder/{id}")
    public ResponseEntity<ProductOrder> editProductOrder(@RequestBody ProductOrder newProductOrder,
                                                         @PathVariable("id")Long id) {
    return new ResponseEntity<>(productOrderService.editProductOrder(id, newProductOrder),
            HttpStatus.OK);
    }

    }

