package com.example.examprojectfall2022.service;

import com.example.examprojectfall2022.model.Delivery;
import com.example.examprojectfall2022.model.Destination;
import com.example.examprojectfall2022.model.Warehouse;
import com.example.examprojectfall2022.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final WarehouseService warehouseService;
    private final DestinationService destinationService;

    //constructor injection
    @Autowired
    DeliveryService(final DeliveryRepository deliveryRepository,
                    final WarehouseService warehouseService, final DestinationService destinationService) {
        this.deliveryRepository = deliveryRepository;
        this.warehouseService = warehouseService;
        this.destinationService = destinationService;
    }

    //find all delivery
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    //find delivery by id
    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    //create delivery
    public Delivery createDelivery(Delivery delivery, Long warehouseId, Long destinationId) {
        Warehouse warehouse = warehouseService.getWarehouseById(warehouseId);
        Destination destination = destinationService.getDestinationById(destinationId);
        delivery.setWarehouse(warehouse);
        delivery.setDestination(destination);
        return deliveryRepository.save(delivery);
    }

    //delete delivery
    public void deleteDeliveryById(Long id) {
        deliveryRepository.deleteById(id);
    }

    //edit delivery
    public Delivery editDelivery(Long id, Delivery newDelivery) {
        if (deliveryRepository.findById(id).isEmpty()) {
            return null;
        }
        return deliveryRepository.save(newDelivery);
    }

}
