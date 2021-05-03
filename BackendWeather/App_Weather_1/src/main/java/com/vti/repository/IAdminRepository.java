package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {
	
//	@Query("SELECT EXISTS (select * FROM `Admin` WHERE Email = ?1 AND `Password`= sha2(?2,256))")
	public boolean existsByEmailAndPassword(String email, String password);
}