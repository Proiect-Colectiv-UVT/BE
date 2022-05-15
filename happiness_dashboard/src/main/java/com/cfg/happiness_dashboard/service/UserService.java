package com.cfg.happiness_dashboard.service;

import java.util.List;

import com.cfg.happiness_dashboard.entity.Poll;
import com.cfg.happiness_dashboard.entity.User;
import com.cfg.happiness_dashboard.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public List<User> all() {
		return repository.findAll();
	}

	public User getUserById(Long id)
	{
		return repository.getUserById(id);
	}


	public User getUserByName(User user)
	{
		return repository.getUserByName(user.getName());
	}

	public User addUser(User user)
	{
        User checkUser = repository.getUserByName(user.getName());
        if(checkUser == null)
            return repository.save(user);
        else
            return null;
	}

	public User addPoll(Long id, Poll poll)
	{
		User user = repository.getUserById(id);		
		user.getPollsCreated().add(poll);
        
		return repository.save(user);
	}


	public String deleteUser(Long id)
	{
		repository.delete(repository.getUserById(id));
		return "Deleted successfully";
	}


}
