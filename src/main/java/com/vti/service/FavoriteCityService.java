package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.FavoriteCity;
import com.vti.repository.IFavoriteCityRepository;

@Service
public class FavoriteCityService implements IFavoriteCityService{

	@Autowired
	private  IFavoriteCityRepository favoriteCityRepository;
	
	@Override
	public List<FavoriteCity> getAllFavoriteCities() {
		
		return (List<FavoriteCity>) favoriteCityRepository.findAll();
	}

	@Override
	public void createGroup(FavoriteCity favoriteCity) {
		favoriteCityRepository.save(favoriteCity);
	}
}