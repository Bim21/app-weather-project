package com.vti.utils;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.entity.Admin;
import com.vti.repository.IAdminRepository;
import com.vti.repository.IUserRepository;



/**
 * This class JwtRequestFilter.
 * 
 * @Description: .
 * @author: Đinh Huy Khánh
 * @create_date: 3/5/2021
 * @version: 1.0
 * @modifer: 
 * @modifer_date: 
 */	

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserRepository userRepository;

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IAdminRepository adminDAO;


	/**
	 * This method is loadUserByUsername.
	 * 
	 * @Description: .
	 * @author: Đinh Huy Khánh
	 * @create_date: 3/5/2021
	 * @version: 1.0
	 * @modifer: 
	 * @modifer_date: 
	 * @return : userDetail
	 */	
	/* để tìm user theo user name khi sử dụng token để xác thực */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = adminDAO.findByEmail(email);
		if(Objects.isNull(admin)) {
			throw new UsernameNotFoundException(email +"not found");
		}
		User userDetail = new org.springframework.security.core.userdetails.User(email,
                passwordEncoder.encode("facebook"),
                new ArrayList<>());
        return userDetail;
	}

}
