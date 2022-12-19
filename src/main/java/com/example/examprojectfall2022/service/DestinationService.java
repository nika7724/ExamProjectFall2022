package com.example.examprojectfall2022.service;

import com.example.examprojectfall2022.model.Destination;
import com.example.examprojectfall2022.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(final DestinationRepository destinationRepository){
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public Destination getDestinationById(Long id) {
        return destinationRepository.findById(id).orElse(null);
    }

}
