package com.cfg.happiness_dashboard.controller;

import java.util.List;

import com.cfg.happiness_dashboard.entity.Poll;
import com.cfg.happiness_dashboard.entity.Result;
import com.cfg.happiness_dashboard.service.PollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollController {
	
	@Autowired
    private final PollService pollService;

	public PollController(PollService pollService) {
		this.pollService = pollService;
	}

	@GetMapping("/polls")
	public List<Poll> all() {
		return pollService.all();
	}


	@GetMapping("/activePolls")
	public List<Poll> activePolls() {

		return pollService.activePolls();
	}

	@GetMapping("/expiredPolls")
	public List<Poll> expiredPolls() {
		return pollService.expiredPolls();
	}


	@GetMapping("/poll/{id}")
	public Poll getPollById(@PathVariable("id") Long id)
	{
		return pollService.getPollById(id);
	}

	@PutMapping("user/{idUser}/poll/{idPoll}/result/add")
	public Poll addResult(@PathVariable("idUser") Long idUser, @PathVariable("idPoll") Long idPoll, @RequestBody Result result)
	{

        return pollService.addResult(idUser,idPoll,result);
    }

}
