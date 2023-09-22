package com.example.demo.stockcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.fruits;
import com.example.demo.service.FruitService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fruits")
@CrossOrigin
public class FruitsController {
	
	@Autowired
    private final FruitService fruitsService;

    public FruitsController(FruitService fruitsService) {
        this.fruitsService = fruitsService;
    }

    // Create a new fruit
    @PostMapping
    public ResponseEntity<fruits> createFruit(@RequestBody fruits fruit) {
        fruits createdFruit = fruitsService.createFruit(fruit);
        return ResponseEntity.ok(createdFruit);
    }

    // Get all fruits
    @GetMapping
    public ResponseEntity<List<fruits>> getAllFruits() {
        List<fruits> fruitsList = fruitsService.getAllFruits();
        return ResponseEntity.ok(fruitsList);
    }

    // Get a fruit by ID
    @GetMapping("/{id}")
    public ResponseEntity<fruits> getFruitById(@PathVariable Integer id) {
        Optional<fruits> fruit = fruitsService.getFruitById(id);
        if (fruit.isPresent()) {
            return ResponseEntity.ok(fruit.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a fruit by ID
    @PutMapping("/{id}")
    public ResponseEntity<fruits> updateFruit(@PathVariable Integer id, @RequestBody fruits updatedFruit) {
        fruits updated = fruitsService.updateFruit(id, updatedFruit);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a fruit by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable Integer id) {
        fruitsService.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }
    
    // Get paginated list of fruits with ascending sorting
    @GetMapping("/page/{page}/size/{size}")
    public Page<fruits> getFruitsWithPagination(
            @PathVariable int page,
            @PathVariable int size
    ) {
        Page<fruits> fruitsPage = fruitsService.getFruitsWithPagination(page, size);
        return fruitsPage;
    }
    
    @GetMapping("/sorted/{sortField}")
    public List<fruits> getFruitsWithSorting(
            @PathVariable String sortField
    ) {
        List<fruits> sortedFruits = fruitsService.getFruitsWithSorting(sortField);
        return sortedFruits;
    }
    
    @GetMapping("/sorted-desc/{sortField}")
    public List<fruits> getFruitsWithDescendingSorting(
            @PathVariable String sortField
    ) {
        List<fruits> sortedFruits = fruitsService.getFruitsWithDescendingSorting(sortField);
        return sortedFruits;
    }
}
