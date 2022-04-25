package com.cfg.happiness_dashboard.repository;

import com.cfg.happiness_dashboard.entity.Poll;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll , Long> {
    
}
