package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.User;
import com.vti.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;
	
	/**
	 * This method is exists User By ID.
	 * 
	 * @Description: .
	 * @author: Đinh Huy Khánh
	 * @create_date: 3/5/2021
	 * @version: 1.0
	 * @modifer: 
	 * @modifer_date: 
	 * @param : email 
	 * @param : password
	 * @return : 
	 */
	@Override
	public boolean isExistsUserById(String id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}

	/**
	 * This method create User.
	 * 
	 * @Description: .
	 * @author: Đinh Huy Khánh
	 * @create_date: 3/5/2021
	 * @version: 1.0
	 * @modifer: 
	 * @modifer_date: 
	 * @param :  
	 * @param : 
	 * @return : 
	 */
	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
	}

}
