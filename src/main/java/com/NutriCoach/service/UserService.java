package com.NutriCoach.service;

import java.util.List;
import java.util.Optional;

import com.NutriCoach.entities.User;

public interface UserService {
	List<User> findAll() throws Exception;

	User save(User t)throws Exception;

	User update(User t)throws Exception;

	Optional<User> findById(Integer id)throws Exception;

	void deleteById(Integer id)throws Exception;
	
	void deleteAll()throws Exception;
}
