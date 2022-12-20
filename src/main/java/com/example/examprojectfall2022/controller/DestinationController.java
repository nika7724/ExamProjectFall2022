package com.example.examprojectfall2022.controller;

import com.example.examprojectfall2022.model.Destination;
import com.example.examprojectfall2022.model.Warehouse;
import com.example.examprojectfall2022.service.DestinationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(final DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    //getAll
    @GetMapping("/destinations")
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }
}

