package com.cfg.happiness_dashboard.service;

import java.sql.Date;
import java.util.List;

import com.cfg.happiness_dashboard.entity.Poll;
import com.cfg.happiness_dashboard.entity.Result;
import com.cfg.happiness_dashboard.repository.PollRepository;

import org.springframework.stereotype.Service;


@Service
public class PollService {
    
    private final PollRepository repository;

	public PollService(PollRepository repository) {
		this.repository = repository;
	}

	public List<Poll> all() {
		return repository.findAll();
	}


	public List<Poll> activePolls() {
		List<Poll> polls = repository.findAll();

		java.util.Date date = new java.util.Date();
        java.sql.Date todayDate = new Date(date.getTime());

		polls.removeIf(a -> (a.getExpiryDate().compareTo(todayDate) < 0) );
		return polls;
	}

	public List<Poll> expiredPolls() {
		List<Poll> polls = repository.findAll();

		java.util.Date date = new java.util.Date();
        java.sql.Date todayDate = new Date(date.getTime());

		polls.removeIf(a -> (a.getExpiryDate().compareTo(todayDate) >= 0) );
		return polls;
	}


	public Poll getPollById(Long id)
	{
		return repository.getPollById(id);
	}

	public Poll addResult(Long idUser, Long idPoll, Result result)
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
