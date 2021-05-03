package com.vti.service;

import com.vti.entity.User;

public interface IUserService {
	public boolean isExistsUserById(String id);
	
	public void createUser(User user);
}

