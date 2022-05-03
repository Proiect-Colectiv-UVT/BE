package com.cfg.happiness_dashboard.controller;

import java.sql.Date;
import java.util.List;

import com.cfg.happiness_dashboard.entity.Poll;
import com.cfg.happiness_dashboard.entity.Result;
import com.cfg.happiness_dashboard.repository.PollRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PutMapping("poll/{id}/result/add")
	public Poll addResult(@PathVariable("id") Long id, @RequestBody Result result)
	{
		Poll poll = repository.getPollById(id);
		
		java.util.Date date = new java.util.Date();
        java.sql.Date todayDate = new Date(date.getTime());
		result.setDate(todayDate);

		poll.getPollResults().add(result);
        return repository.save(poll);
    }

}
