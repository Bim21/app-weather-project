package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.repository.IAdminRepository;

@Service
public class AdminService implements IAdminService{

	
	@Autowired
	private IAdminRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * This method is exists By Email And Password.
	 * 
	 * @Description: .
	 * @author: Đinh Huy Khánh
	 * @create_date: 3/5/2021
	 * @version: 1.0
	 * @modifer: 
	 * @modifer_date: 
	 * @param : email 
	 * @param : password
	 */
	public boolean isAdminExistsByEmailAndPassword(String email, String password) {
		// chuyển string password về sha256
		String pswHash = passwordEncoder.encode(password);
		return repository.existsByEmailAndPassword(email, pswHash);
	}
	
	
}
