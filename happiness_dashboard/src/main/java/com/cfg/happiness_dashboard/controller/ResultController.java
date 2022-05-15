package com.cfg.happiness_dashboard.controller;


import java.util.List;

import com.cfg.happiness_dashboard.entity.Result;
import com.cfg.happiness_dashboard.service.ResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

	@Autowired
    ResultService resultService;


    public ResultController(ResultService resultService) {
		this.resultService = resultService;
	}

	@GetMapping("/results")
	public List<Result> all() {
		return resultService.all();
	}

    @GetMapping("/result/{id}")
	public Result getResultById(@PathVariable("id") Long id)
	{
		return resultService.getResultById(id);
	}

}
