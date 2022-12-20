package com.example.examprojectfall2022.service;

import com.example.examprojectfall2022.model.Product;
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

     //create product
    public Warehouse createWharehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public void deleteWareHouseById(Long id) {
        warehouseRepository.deleteById(id);
    }

    public Warehouse editWareHouse(Long id, Warehouse newWarehouse) {
        if (warehouseRepository.findById(id).isEmpty())
            return null;
        {
            return warehouseRepository.save(newWarehouse);
        }
    }
}
