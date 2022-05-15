package com.cfg.happiness_dashboard.controller;

import java.util.List;

import com.cfg.happiness_dashboard.entity.Poll;
import com.cfg.happiness_dashboard.entity.User;
import com.cfg.happiness_dashboard.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("users")
	public List<User> all() {
		return userService.all();
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") Long id)
	{
		return userService.getUserById(id);
	}


	@PostMapping ("/user/login")
	public User getUserByName(@RequestBody User user)
	{
		return userService.getUserByName(user);
	}

    @PostMapping("user/add")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}

	@PutMapping("user/{id}/poll/add")
	public User addPoll(@PathVariable("id") Long id, @RequestBody Poll poll)
	{
        
		return userService.addPoll(id,poll);
	}


	@DeleteMapping("user/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id)
	{
		
		return userService.deleteUser(id);
	}

}
