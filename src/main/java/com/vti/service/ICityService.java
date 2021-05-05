package com.vti.service;

import java.util.List;

import com.vti.dto.CityDTO;
import com.vti.entity.City;

public interface ICityService {

	public List<CityDTO> getAllCities(String search);
	
	public City getCityByName(String name);
	
	public City getCityById(int id);
}