package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.FavoriteCityDTO;
import com.vti.entity.City;
import com.vti.entity.FavoriteCity;
import com.vti.entity.FavoriteCityKey;
import com.vti.entity.User;
import com.vti.service.ICityService;
import com.vti.service.IFavoriteCityService;
import com.vti.service.IUserService;


@RestController
@RequestMapping(value = "api/v1/favoriteCities")
@CrossOrigin("*")
public class FavoriteCityController {

	@Autowired
	private IFavoriteCityService favoriteCityService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICityService cityService;
	
	@GetMapping()
	public ResponseEntity<?> getAllFavoriteCities() {

		// get data
		List<FavoriteCity> entities = favoriteCityService.getAllFavoriteCities();

		return new ResponseEntity<List<FavoriteCity>>(entities, HttpStatus.OK);
	}
	
	@PostMapping()
	public String createGroup(@RequestBody FavoriteCityDTO dto) {

		FavoriteCityKey favoriteCityKey = new FavoriteCityKey(dto.getUserId(), dto.getCityId());
		
		dto.setFavoriteCityKey(favoriteCityKey);
		
		dto.setCity(cityService.getCityById(dto.getCityId()));	
		
		dto.setUser(userService.getUserById(dto.getUserId()));
		
		favoriteCityService.createGroup(dto.toEntity());
		return "{ \"message\":"+"\"Create Successfully\"" + "}";

	}
}
