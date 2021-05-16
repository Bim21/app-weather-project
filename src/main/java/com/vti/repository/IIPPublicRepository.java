package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.vti.entity.IPPublic;

public interface IIPPublicRepository extends JpaRepository<IPPublic, Character>,JpaSpecificationExecutor<IPPublic>{
	
	public boolean existsByIpPublic(String ip);
//	public IPPublic createIpPublic(IPPublic entity);
	
	 @Query("select count(*) from IPPublic")
	public Long countByIpPublic();
	
	
}
