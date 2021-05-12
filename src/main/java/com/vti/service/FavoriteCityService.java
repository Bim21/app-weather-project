package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.FavoriteCity;
import com.vti.entity.FavoriteCityKey;
import com.vti.entity.User;
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
	public void createFavoriteCity(FavoriteCity favoriteCity) {
		favoriteCityRepository.save(favoriteCity);
	}

	@Override
	public List<FavoriteCity> getAllFavoriteCitiesByUserId(User user) {
		return (List<FavoriteCity>) favoriteCityRepository.findByUser(user);
	}

	@Override
	public void deleteFavoriteCity(String idUser, Integer idCity) {
		FavoriteCityKey favoriteCityKey = new FavoriteCityKey(idUser,idCity);
		favoriteCityRepository.deleteById(favoriteCityKey);
	}
}
