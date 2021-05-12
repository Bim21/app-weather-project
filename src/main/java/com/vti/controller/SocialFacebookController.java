package com.vti.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.vti.dto.UserDTO;
import com.vti.repository.IUserRepository;
import com.vti.service.IUserService;
import com.vti.utils.JwtUtil;
import com.vti.utils.ResponseJwt;
import com.vti.utils.TokenDTO;

@RestController
@CrossOrigin("*")
public class SocialFacebookController {
//	private FacebookConnectionFactory factory = new FacebookConnectionFactory("369670134345835", "570606df435a940368c786d59a2dae4f");
//	private User userProfile;
	
	@Autowired
	private PasswordEncoder passwrodEncoder;
	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtUtil jwtUtil;

	    @Autowired
	    @Qualifier("userDetailsService")
	    private UserDetailsService  userDetailsService;
	    
	    @Autowired
	    private IUserRepository userRepository;
	
	 
	
	@Autowired 
	IUserService userService;
	
	/**
	 * This method is login Facebook.
	 * 
	 * @Description: .
	 * @author: Đinh Huy Khánh
	 * @create_date: 3/5/2021
	 * @version: 1
	 * @modifer: 
	 * @modifer_date: 
	 * @return : result
	 */	
	@PostMapping(value ="/auth/facebook")
	public ResponseJwt loginFacebook(@RequestBody TokenDTO token) {
		ResponseJwt result = new ResponseJwt();
		Facebook facebook = new FacebookTemplate(token.getToken());
		String[] fields = {"id","email","name","address"};// tên cột cần lấy
		User user = facebook.fetchObject("me", User.class,fields);
		if(userRepository.existsById(user.getId())) {
			com.vti.entity.User entity = new com.vti.entity.User();
			entity.setId(user.getId());
			entity.setEmail(user.getEmail());
//			entity.setAddress(user.getAddress().getCountry());
			entity.setName(user.getName());
			userRepository.save(entity);
		}
		com.vti.entity.User entity = userRepository.findById(user.getId());
		if(Objects.nonNull(entity)) {
			Map<String, Object> map = new HashMap<>();
			String jwt = generateTokenFace(entity.getId());
			map.put("jwt", jwt);
			map.put("data", entity);
			result.setData(map);
			result.setMessage("Success");
		}else {
			result.setMessage("Fail");
		}
		return result;
	}

	

//	/**
//	 * This method is get User Login Facebook.
//	 * 
//	 * @Description: .
//	 * @author: Đinh Huy Khánh
//	 * @create_date: 6/5/2021
//	 * @version: 1.0
//	 * @modifer: 
//	 * @modifer_date: 
//	 * @return : userProfile
//	 */
//	@GetMapping(value="/login/user")
//	public User getUserLoginFacebook() {
//		
//		return userProfile;
//	}
	
	
	
	private String generateTokenFace(String id) {
		final UserDetails userDetails = userDetailsService.loadUserByUsername(id);
		String jwt = jwtUtil.generateToken(userDetails);
		return jwt;
	}
	
	
	
	
}
