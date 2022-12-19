package com.example.examprojectfall2022.controller;


import com.example.examprojectfall2022.model.Delivery;
import com.example.examprojectfall2022.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    private final DeliveryService deliveryService;

@Autowired
public DeliveryController(final DeliveryService deliveryService) {
    this.deliveryService = deliveryService;
}

//return all item
    @GetMapping("/deliveries")
    public List<Delivery> getAllDeliveries() {
    return deliveryService.getAllDeliveries();
    }

//find by id
    @GetMapping("/delivery/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable("id") Long id) {
    Delivery delivery = deliveryService.getDeliveryById(id);
    return new ResponseEntity<>(delivery, HttpStatus.OK);
    }

//create new delivery
    @PostMapping("/delivery")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
    Delivery newDelivery = deliveryService.createDelivery(delivery);
    return new ResponseEntity<>(newDelivery, HttpStatus.CREATED);
    }

//delete delivery
    @DeleteMapping("/delivery/{id}")
    public ResponseEntity<?> deleteDelivery(@PathVariable("id") Long id) {
    deliveryService.deleteDeliveryById(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }

//edit delivery
    @PutMapping("/delivery/{id}")
public ResponseEntity<Delivery> editDelivery
    (@RequestBody Delivery newDelivery, @PathVariable Long id) {
    return new ResponseEntity<>(deliveryService.editDelivery(id, newDelivery), HttpStatus.OK);
    }
}
