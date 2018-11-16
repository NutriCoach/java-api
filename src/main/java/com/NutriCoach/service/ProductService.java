package com.NutriCoach.service;

import java.util.List;
import java.util.Optional;

import com.NutriCoach.entities.Product;

public interface ProductService {
	List<Product> findAll() throws Exception;

	Product save(Product t)throws Exception;

	Product update(Product t)throws Exception;

	Optional<Product> findById(Integer id)throws Exception;

	void deleteById(Integer id)throws Exception;
	
	void deleteAll()throws Exception;
}
