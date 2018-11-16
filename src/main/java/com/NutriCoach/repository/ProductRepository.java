package com.NutriCoach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NutriCoach.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
