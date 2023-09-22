package com.example.demo.stockcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.vegetables;
import com.example.demo.service.VegetableService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vegetables")
@CrossOrigin
public class VegetableController {
	
	@Autowired
    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    // Create a new vegetable
    @PostMapping
    public ResponseEntity<vegetables> createVegetable(@RequestBody vegetables vegetable) {
        vegetables createdVegetable = vegetableService.createVegetable(vegetable);
        return ResponseEntity.ok(createdVegetable);
    }

    // Get all vegetables
    @GetMapping
    public ResponseEntity<List<vegetables>> getAllVegetables() {
        List<vegetables> vegetablesList = vegetableService.getAllVegetables();
        return ResponseEntity.ok(vegetablesList);
    }

    // Get a vegetable by ID
    @GetMapping("/{id}")
    public ResponseEntity<vegetables> getVegetableById(@PathVariable Integer id) {
        Optional<vegetables> vegetable = vegetableService.getVegetableById(id);
        if (vegetable.isPresent()) {
            return ResponseEntity.ok(vegetable.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a vegetable by ID
    @PutMapping("/{id}")
    public ResponseEntity<vegetables> updateVegetable(@PathVariable Integer id, @RequestBody vegetables updatedVegetable) {
        vegetables updated = vegetableService.updateVegetable(id, updatedVegetable);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a vegetable by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVegetable(@PathVariable Integer id) {
        vegetableService.deleteVegetable(id);
        return ResponseEntity.noContent().build();
    }
}

