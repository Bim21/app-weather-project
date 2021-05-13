package com.vti.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "`FavouriteCity`", catalog = "heroku_b127bd7a389e7b4")
public class FavoriteCity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	FavoriteCityKey favoriteCityId;
	

	@ManyToOne
	@MapsId("FacebookID")
	@JoinColumn(name = "FacebookID", nullable = false)
	@GeneratedValue
    private User user;
	
	@ManyToOne
	@MapsId("CityID")
	@JoinColumn(name = "CityID", nullable = false)
    private City city;


	public String getUserId() {
		return user.getId();
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public City getCity() {
//		return city;
//	}

	public int getCityId() {
		return city.getId();
	}
	
	public void setCity(City city) {
		this.city = city;
	}

	public FavoriteCity() {
		
	}

	public FavoriteCity(User user, City city) {
		this.user = user;
		this.city = city;
	}

	public FavoriteCity(FavoriteCityKey favoriteCityId, User user, City city) {
		this.favoriteCityId = favoriteCityId;
		this.user = user;
		this.city = city;
	}
	

	public FavoriteCity(FavoriteCityKey favoriteCityId) {
		this.favoriteCityId = favoriteCityId;
	}

	@Override
	public String toString() {
		return "FavoriteCity [userId=" + user.getId() + ", cityId=" + city.getId() + "]";
	}
	
}
