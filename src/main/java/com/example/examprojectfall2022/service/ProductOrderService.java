package com.example.examprojectfall2022.service;

import com.example.examprojectfall2022.model.Delivery;
import com.example.examprojectfall2022.model.Product;
import com.example.examprojectfall2022.model.ProductOrder;
import com.example.examprojectfall2022.repository.ProductOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {

    private final ProductOrderRepository productOrderRepository;
    private final ProductService productService;
    private final DeliveryService deliveryService;

    public ProductOrderService(final ProductOrderRepository productOrderRepository,
                               final ProductService productService,
                               final DeliveryService deliveryService) {
        this.productOrderRepository = productOrderRepository;
        this.productService = productService;
        this.deliveryService = deliveryService;
    }

    //get all ProductOrder
    List<ProductOrder> getAllProductOrder() {
        return productOrderRepository.findAll();
    }

    //get productOrderById
    public ProductOrder getProductOrderById(Long id) {
        return productOrderRepository.findById(id).orElse(null);
    }

    //create productOrder
    public ProductOrder createProductOrder(ProductOrder productOrder,
                                           Long productId, Long deliveryId) {
        Product product = productService.getProductById(productId);
        Delivery delivery = deliveryService.getDeliveryById(deliveryId);
        productOrder.setProduct(product);
        productOrder.setDelivery(delivery);
        return productOrderRepository.save(productOrder);
    }

    //delete productOrder
    public void deleteProductOrder(Long id) {
        productOrderRepository.deleteById(id);
    }

    //edit productOrder
    public ProductOrder editProductOrder(Long id, ProductOrder newProductOrder) {
        if (productOrderRepository.findById(id).isEmpty()) {
            return null;
        }
        return productOrderRepository.save(newProductOrder);
    }

}
