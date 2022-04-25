package com.cfg.happiness_dashboard.controller;

import java.util.List;

import com.cfg.happiness_dashboard.entity.User;
import com.cfg.happiness_dashboard.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/users")
	public List<User> all() {
		return repository.findAll();
	}

	@GetMapping("/user/{id}")
	public User getUserByID(@PathVariable("id") Long id)
	{

		return repository.getUserById(id);
	}
    
}
