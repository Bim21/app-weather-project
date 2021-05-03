package com.vti.service;

import java.util.List;
import com.vti.entity.FavoriteCity;


public interface IFavoriteCityService {
	public List<FavoriteCity> getAllFavoriteCities();

	public void createFavoriteCity(FavoriteCity favoriteCity);
}
