package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.FavoriteCity;

public interface IFavoriteCityRepository extends JpaRepository<FavoriteCity, Integer>, JpaSpecificationExecutor<FavoriteCity> {
	
	
}
