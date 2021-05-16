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
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		com.vti.entity.User user = userRepository.findById(id);
		if(Objects.isNull(user)) {
			throw new UsernameNotFoundException(id +"not found");
		}
		User userDetail = new org.springframework.security.core.userdetails.User(id,
                passwordEncoder.encode("facebook"),
                new ArrayList<>());
        return userDetail;
	}

}
