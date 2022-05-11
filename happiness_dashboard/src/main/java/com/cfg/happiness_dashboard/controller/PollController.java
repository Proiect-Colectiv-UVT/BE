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


	@GetMapping("/activePolls")
	public List<Poll> activePolls() {
		List<Poll> polls = repository.findAll();

		java.util.Date date = new java.util.Date();
        java.sql.Date todayDate = new Date(date.getTime());

		polls.removeIf(a -> (a.getExpiryDate().compareTo(todayDate) < 0) );
		return polls;
	}

	@GetMapping("/expiredPolls")
	public List<Poll> expiredPolls() {
		List<Poll> polls = repository.findAll();

		java.util.Date date = new java.util.Date();
        java.sql.Date todayDate = new Date(date.getTime());

		polls.removeIf(a -> (a.getExpiryDate().compareTo(todayDate) >= 0) );
		return polls;
	}


	@GetMapping("/poll/{id}")
	public Poll getPollByID(@PathVariable("id") Long id)
	{
		return repository.getPollById(id);
	}

	@PutMapping("user/{idUser}/poll/{idPoll}/result/add")
	public Poll addResult(@PathVariable("idUser") Long idUser, @PathVariable("idPoll") Long idPoll, @RequestBody Result result)
	{
		Poll poll = repository.getPollById(idPoll);
		if(poll.getVotedBy().contains(idUser))
			return poll;
		
		java.util.Date date = new java.util.Date();
        java.sql.Date todayDate = new Date(date.getTime());
		result.setDate(todayDate);

		poll.getPollResults().add(result);
		poll.getVotedBy().add(idUser);

        return repository.save(poll);
    }

}
