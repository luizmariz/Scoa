package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fesg3.server.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
