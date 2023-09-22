package com.example.demo.model.stockrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.fruits;

public interface FruitRepository extends JpaRepository<fruits, Integer> {

}
