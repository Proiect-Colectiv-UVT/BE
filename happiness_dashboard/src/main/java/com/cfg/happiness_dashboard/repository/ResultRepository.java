package com.cfg.happiness_dashboard.repository;

import com.cfg.happiness_dashboard.entity.Result;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result , Long>{

    Result getResultById(Long id);
    
}
