package com.vti.service;

import java.util.List;
import com.vti.entity.FavoriteCity;
import com.vti.entity.User;


public interface IFavoriteCityService {
	public List<FavoriteCity> getAllFavoriteCities();

	public void createFavoriteCity(FavoriteCity favoriteCity);
	
	public List<FavoriteCity> getAllFavoriteCitiesByUserId(User user);

	public void deleteFavoriteCity(String idUser, Integer idCity);
}
