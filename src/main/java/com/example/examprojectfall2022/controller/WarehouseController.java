package com.example.examprojectfall2022.controller;

import com.example.examprojectfall2022.model.ProductDescription;
import com.example.examprojectfall2022.model.Warehouse;
import com.example.examprojectfall2022.service.ProductDescriptionService;
import com.example.examprojectfall2022.service.WarehouseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(final WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    //getAll
    @GetMapping("/warehouses")
    public List<Warehouse> getAllWarehouse() {
        return warehouseService.getAllWarehouses();
    }
}
