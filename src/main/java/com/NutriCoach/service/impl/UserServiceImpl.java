package com.NutriCoach.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.NutriCoach.entities.User;
import com.NutriCoach.repository.UserRepository;
import com.NutriCoach.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Transactional(readOnly=true)
	@Override
	public List<User> findAll() throws Exception {
		return userRepo.findAll();
	}

	@Transactional
	@Override
	public User save(User t) throws Exception {
		return userRepo.save(t);
	}

	@Transactional
	@Override
	public User update(User t) throws Exception {
		return userRepo.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<User> findById(Integer id) throws Exception {
		return userRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		userRepo.deleteById(id);
	}
	
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		userRepo.deleteAll();
	}

}
