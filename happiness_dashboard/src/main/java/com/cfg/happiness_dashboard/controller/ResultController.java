package com.cfg.happiness_dashboard.controller;


import java.util.List;

import com.cfg.happiness_dashboard.entity.Result;
import com.cfg.happiness_dashboard.repository.ResultRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    private final ResultRepository repository;

    public ResultController(ResultRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/results")
	public List<Result> all() {
		return repository.findAll();
	}

    @GetMapping("/result/{id}")
	public Result getPollByID(@PathVariable("id") Long id)
	{
		return repository.getResultById(id);
	}

}
