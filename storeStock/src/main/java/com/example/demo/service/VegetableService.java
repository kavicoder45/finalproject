package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.vegetables;
import com.example.demo.model.stockrepository.vegetableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableService {
	
	@Autowired
    private final vegetableRepository vegrepository;

    public VegetableService(vegetableRepository vegrepository) {
        this.vegrepository = vegrepository;
    }

    // Create operation
    public vegetables createVegetable(vegetables vegetable) {
        return vegrepository.save(vegetable);
    }

    // Read operation
    public List<vegetables> getAllVegetables() {
        return vegrepository.findAll();
    }

    public Optional<vegetables> getVegetableById(Integer id) {
        return vegrepository.findById(id);
    }

    // Update operation
    public vegetables updateVegetable(Integer id, vegetables updatedVegetable) {
        Optional<vegetables> existingVegetable = vegrepository.findById(id);
        if (existingVegetable.isPresent()) {
            vegetables vegetableToUpdate = existingVegetable.get();
            vegetableToUpdate.setVegetableName(updatedVegetable.getVegetableName());
            vegetableToUpdate.setQuantity(updatedVegetable.getQuantity());
            vegetableToUpdate.setPrice(updatedVegetable.getPrice());
            return vegrepository.save(vegetableToUpdate);
        } else {
        	return null;
        }
    }

    // Delete operation
    public void deleteVegetable(Integer id) {
        vegrepository.deleteById(id);
    }
}
