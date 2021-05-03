package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.repository.IAdminRepository;

@Service
public class AdminService  implements IAdminService {

	@Autowired
	private IAdminRepository repository;
	
	public boolean isAdminExistsByEmailAndPassword(String email, String password) {
		// chuyển string password về sha256
		String sha256hexPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password); 
		return repository.existsByEmailAndPassword(email, sha256hexPassword);
	}
	
}
