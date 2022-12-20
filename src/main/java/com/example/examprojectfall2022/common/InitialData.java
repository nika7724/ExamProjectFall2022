package com.example.examprojectfall2022.common;

import com.example.examprojectfall2022.model.*;
import com.example.examprojectfall2022.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitialData implements CommandLineRunner {

DeliveryRepository deliveryRepository;
ProductRepository productRepository;
ProductOrderRepository productOrderRepository;
ProductDescriptionRespository productDescriptionRespository;
WarehouseRepository warehouseRepository;
DestinationRepository destinationRepository;
;

public InitialData(DeliveryRepository deliveryRepository, ProductRepository productRepository,
                   ProductOrderRepository productOrderRepository,
                   ProductDescriptionRespository productDescriptionRespository,
                   WarehouseRepository warehouseRepository, DestinationRepository destinationRepository) {
    this.deliveryRepository = deliveryRepository;
    this.productRepository = productRepository;
    this.productOrderRepository = productOrderRepository;
    this.productDescriptionRespository = productDescriptionRespository;
    this.warehouseRepository = warehouseRepository;
    this.destinationRepository = destinationRepository;
}

@Override
public void run(String... args) throws Exception {
    //create productDescription
    ProductDescription productDescription1 = new ProductDescription("Vegetable");
    ProductDescription productDescription2 = new ProductDescription("Daily");
    ProductDescription productDescription3 = new ProductDescription("Fruits");
    productDescriptionRespository.save(productDescription1);
    productDescriptionRespository.save(productDescription2);
    productDescriptionRespository.save(productDescription3);

    //create product object
    Product product1 = new Product("Onion", 15, 500, productDescription1);
    Product product2 = new Product("Milk", 10, 1000, productDescription2);
    Product product3 = new Product("Banana", 2, 10, productDescription3);
    productRepository.save(product1);
    productRepository.save(product2);
    productRepository.save(product3);

    //create warehouse
    Warehouse warehouse1 = new Warehouse("warehouse1");
    Warehouse warehouse2 = new Warehouse("warehouse2");
    Warehouse warehouse3 = new Warehouse("warehouse3");
    warehouseRepository.save(warehouse1);
    warehouseRepository.save(warehouse2);
    warehouseRepository.save(warehouse3);

    //createDestination
    Destination destination1 = new Destination("Nika Hansen","RobertJacobsens vej, 15");
    Destination destination2 = new Destination("Mike Hansen","Rosenborgade vej, 20");
    Destination destination3 = new Destination("Jane Hansen","Nilssen vej, 16");
    destinationRepository.save(destination1);
    destinationRepository.save(destination2);
    destinationRepository.save(destination3);

    //create delivery object
    Delivery delivery1 = new Delivery(LocalDate.of(2022,12,23),
            warehouse1, destination1);
    Delivery delivery2 = new Delivery(LocalDate.of(2022,12,24),
            warehouse2, destination2);
    Delivery delivery3 = new Delivery(LocalDate.of(2022,12,28),
            warehouse3, destination3);
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
