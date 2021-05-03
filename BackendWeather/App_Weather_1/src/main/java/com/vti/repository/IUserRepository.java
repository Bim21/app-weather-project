package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.vti.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
	
	// kiểm tra trong User có id chưa
	public boolean existsById(String id);	
}