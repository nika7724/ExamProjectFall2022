package com.example.examprojectfall2022.service;

import com.example.examprojectfall2022.model.Warehouse;
import com.example.examprojectfall2022.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    //get All warehouses
    public List<Warehouse> getAllWarehouses() {
       return warehouseRepository.findAll();
    }

    //get warehouse by id
    public Warehouse getWarehouseById(Long id) {
        return warehouseRepository.findById(id).orElse(null);
    }

}
