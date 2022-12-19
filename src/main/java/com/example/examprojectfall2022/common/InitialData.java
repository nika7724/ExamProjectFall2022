package com.example.examprojectfall2022.common;

import com.example.examprojectfall2022.model.Delivery;
import com.example.examprojectfall2022.model.Product;
import com.example.examprojectfall2022.model.ProductOrder;
import com.example.examprojectfall2022.repository.DeliveryRepository;
import com.example.examprojectfall2022.repository.ProductOrderRepository;
import com.example.examprojectfall2022.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitialData implements CommandLineRunner {

DeliveryRepository deliveryRepository;
ProductRepository productRepository;
ProductOrderRepository productOrderRepository;

public InitialData(DeliveryRepository deliveryRepository, ProductRepository productRepository,
                   ProductOrderRepository productOrderRepository) {
    this.deliveryRepository = deliveryRepository;
    this.productRepository = productRepository;
    this.productOrderRepository = productOrderRepository;
}

@Override
public void run(String... args) throws Exception {

    //create product object
    Product product1 = new Product("Onion", 15, 500);
    Product product2 = new Product("Milk", 10, 1000);
    Product product3 = new Product("Cheese", 35, 350);
    productRepository.save(product1);
    productRepository.save(product2);
    productRepository.save(product3);

    //create delivery object

    Delivery delivery1 = new Delivery(LocalDate.of(2022,12,23),
            "warehouse1", "CopenhagenS");
    Delivery delivery2 = new Delivery(LocalDate.of(2022,12,24),
            "warehouse2", "CopenhagenE");
    Delivery delivery3 = new Delivery(LocalDate.of(2022,12,28),
            "warehouse3", "CopenhagenW");
deliveryRepository.save(delivery1);
deliveryRepository.save(delivery2);
deliveryRepository.save(delivery3);


    //create Product Order object

    ProductOrder productOrder1 = new ProductOrder(15, product1, delivery1);
    ProductOrder productOrder2 = new ProductOrder(10, product2, delivery2);
    ProductOrder productOrder3 = new ProductOrder(10, product3, delivery3);
    productOrderRepository.save(productOrder1);
    productOrderRepository.save(productOrder2);
    productOrderRepository.save(productOrder3);

}

}
