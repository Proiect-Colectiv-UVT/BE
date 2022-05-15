package com.cfg.happiness_dashboard.service;

import java.util.List;

import com.cfg.happiness_dashboard.entity.Result;
import com.cfg.happiness_dashboard.repository.ResultRepository;

import org.springframework.stereotype.Service;

@Service
public class ResultService {
    
    private final ResultRepository repository;


	public ResultService(ResultRepository repository) {
        this.repository = repository;
    }

    public List<Result> all() {
		return repository.findAll();
	}

	public Result getResultById(Long id)
	{
		return repository.getResultById(id);
	}
}
