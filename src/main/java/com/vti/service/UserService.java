package com.vti.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.User;
import com.vti.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public User getUserById(String id) {
		return userRepository.findById(id);
	}
	
	
}
