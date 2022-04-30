package com.cfg.happiness_dashboard.controller;


import java.sql.Date;
import java.util.List;

import com.cfg.happiness_dashboard.entity.Result;
import com.cfg.happiness_dashboard.repository.ResultRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


    @PostMapping("result/add")
	public Result addUser(@RequestBody Result result)
	{
        // java.util.Date date = new java.util.Date();
        // java.sql.Date todayDate = new Date(date.getTime());
        // result.setDate(todayDate);
		return repository.save(result);
	}
}
