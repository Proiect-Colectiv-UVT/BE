package com.cfg.happiness_dashboard.repository;

import com.cfg.happiness_dashboard.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
    User getUserById(Long id);
    User getUserByName(String name);
}
