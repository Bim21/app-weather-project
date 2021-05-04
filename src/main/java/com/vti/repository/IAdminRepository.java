package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Admin;

public interface IAdminRepository extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {

	public boolean existsByEmailAndPassword(String email, String password);
}
