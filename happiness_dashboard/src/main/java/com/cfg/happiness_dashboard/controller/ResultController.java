package com.cfg.happiness_dashboard.controller;

import java.util.List;

import com.cfg.happiness_dashboard.entity.Results;
import com.cfg.happiness_dashboard.repository.ResultsRepository;

import org.springframework.web.bind.annotation.GetMapping;

public class ResultController {

    private final ResultsRepository repository;

    public ResultController(ResultsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/results")
	public List<Results> all() {
		return repository.findAll();
	}
}
