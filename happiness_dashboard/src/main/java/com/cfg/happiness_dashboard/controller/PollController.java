package com.cfg.happiness_dashboard.controller;

import java.util.List;

import com.cfg.happiness_dashboard.entity.Poll;
import com.cfg.happiness_dashboard.repository.PollRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollController {

    private final PollRepository repository;

	public PollController(PollRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/polls")
	public List<Poll> all() {
		return repository.findAll();
	}

	@GetMapping("/poll/{id}")
	public Poll getPollByID(@PathVariable("id") Long id)
	{
		return repository.getPollById(id);
	}
}
