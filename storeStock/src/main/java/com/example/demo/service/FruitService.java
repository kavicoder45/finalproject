package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.fruits;
import com.example.demo.model.stockrepository.FruitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {
	
	@Autowired
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    // Create operation
    public fruits createFruit(fruits fruit) {
        return fruitRepository.save(fruit);
    }

    // Read operation
    public List<fruits> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Optional<fruits> getFruitById(Integer id) {
        return fruitRepository.findById(id);
    }

    // Update operation
    public fruits updateFruit(Integer id, fruits updatedFruit) {
        Optional<fruits> existingFruit = fruitRepository.findById(id);
        if (existingFruit.isPresent()) {
            fruits fruitToUpdate = existingFruit.get();
            fruitToUpdate.setFruitName(updatedFruit.getFruitName());
            fruitToUpdate.setQuantity(updatedFruit.getQuantity());
            fruitToUpdate.setPrice(updatedFruit.getPrice());
            fruitToUpdate.setDescription(updatedFruit.getDescription());
            return fruitRepository.save(fruitToUpdate);
        } else {
            return null; // Return null when the fruit is not found
        }
    }

    // Delete operation
    public void deleteFruit(Integer id) {
        fruitRepository.deleteById(id);
    }
    
    //pagination
    public Page<fruits> getFruitsWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return fruitRepository.findAll(pageable);
    }
    
    public List<fruits> getFruitsWithSorting(String sortField) {
        Sort sort = Sort.by(Sort.Direction.ASC, sortField);
        return fruitRepository.findAll(sort);
    }
    
    public List<fruits> getFruitsWithDescendingSorting(String sortField) {
        Sort sort = Sort.by(Sort.Direction.DESC, sortField);
        return fruitRepository.findAll(sort);
    }
    
   

}
