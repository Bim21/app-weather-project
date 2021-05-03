package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.User;
import com.vti.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;
	
	@Override
	public boolean isExistsUserById(String id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
	}

}
