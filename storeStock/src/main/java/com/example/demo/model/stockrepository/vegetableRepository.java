package com.example.demo.model.stockrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.vegetables;

public interface vegetableRepository  extends JpaRepository<vegetables, Integer>{

}
