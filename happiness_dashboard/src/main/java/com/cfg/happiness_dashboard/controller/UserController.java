package com.cfg.happiness_dashboard.controller;

import java.util.List;

import com.cfg.happiness_dashboard.entity.Poll;
import com.cfg.happiness_dashboard.entity.User;
import com.cfg.happiness_dashboard.repository.UserRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("users")
	public List<User> all() {
		return repository.findAll();
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") Long id)
	{
		return repository.getUserById(id);
	}

	// @GetMapping("/user/login/{name}")
	// public User getUserByName(@PathVariable("name") String name)
	// {
	// 	return repository.getUserByName(name);
	// }

	@PostMapping ("/user/login")
	public User getUserByName(@RequestBody User user)
	{
		return repository.getUserByName(user.getName());
	}

    @PostMapping("user/add")
	public User addUser(@RequestBody User user)
	{
		return repository.save(user);
	}

	@PutMapping("user/{id}/poll/add")
	public User addPoll(@PathVariable("id") Long id, @RequestBody Poll poll)
	{
		User user = repository.getUserById(id);		
		user.getPollsCreated().add(poll);
        return repository.save(user);
    }


	@DeleteMapping("user/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id)
	{
		repository.delete(repository.getUserById(id));
		return "Deleted successfully";
	}

}
