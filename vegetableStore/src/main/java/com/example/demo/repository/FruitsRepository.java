package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Fruits;

public interface FruitsRepository extends JpaRepository<Fruits, Integer> {

}
