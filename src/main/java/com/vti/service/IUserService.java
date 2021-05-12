package com.vti.service;



import java.util.List;

import com.vti.entity.User;

public interface IUserService {
	public User getUserById(String id);
	public boolean isExistsUserById(String id);
	public void createUser(User user);
	public List<User> getAllUsers();
}
