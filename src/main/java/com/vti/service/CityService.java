package com.vti.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.entity.City;
import com.vti.repository.ICityRepository;

@Service
public class CityService implements ICityService {

	@Autowired
	private ICityRepository repository;
	
	public List<City> getAllCities(String search){
	Specification<City> where = null;
	
	// Search	
	if(search != null && search != "") {
		where = searchByField(search, "name");
	
	
	}
		
		return (List<City>) repository.findAll(where);
	}
	
	
	// SearchByField
	public Specification<City> searchByField(String search, String type){
		return new Specification<City>() {
			@Override
			public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.like(root.get(type), "%" + search + "%");
			}
		};
	}

	public City getCityByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public City getCityById(int id) {
		return repository.findById(id);
	}
}