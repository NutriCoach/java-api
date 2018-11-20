package com.NutriCoach.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.NutriCoach.entities.Product;
import com.NutriCoach.repository.ProductRepository;
import com.NutriCoach.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Transactional(readOnly=true)
	@Override
	public List<Product> findAll() throws Exception {
		return productRepo.findAll();
	}
	
	@Transactional
	@Override
	public Product save(Product t) throws Exception {
		return productRepo.save(t);
	}

	@Transactional
	@Override
	public Product update(Product t) throws Exception {
		return productRepo.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Product> findById(Integer id) throws Exception {
		return productRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		productRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		productRepo.deleteAll();
	}

}
