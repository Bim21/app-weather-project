package com.vti.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.vti.dto.UserDTO;
import com.vti.service.IUserService;

@RestController
@CrossOrigin("*")
public class SocialFacebookController {
	private FacebookConnectionFactory factory = new FacebookConnectionFactory("369670134345835", "570606df435a940368c786d59a2dae4f");
	private User userProfile=null;
	
	
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
	 * @return : authenticate
	 */
	@GetMapping(value ="/auth/facebook")
	public String loginFacebook() {
		
		OAuth2Operations operations =  factory.getOAuthOperations();
		OAuth2Parameters parames = new OAuth2Parameters(); // sử dụng lớp OAuth2Parameters để yêu cầu quyền truy cập của facebook
		
		// xác định vị trí máy chủ api chuyển hướng sau khi người dùng hoàn tất ủy quyền
		parames.setRedirectUri("https://vti-aca-april-team1-api.herokuapp.com/callback");
		parames.setScope("email,public_profile");// phạm vi được ủy quyền
		
		String authenticate =  operations.buildAuthenticateUrl(parames); // tạo đường dẫn url với mã xác thực truyền vào  
		
		return authenticate; 
	}
	
	/**
	 * This method is callback Facebook.
	 * 
	 * @Description: .
	 * @author: Đinh Huy Khánh
	 * @create_date: 3/5/2021
	 * @version: 1.1
	 * @modifer: 
	 * @modifer_date: 
	 */
	@GetMapping(value="/callback")
	public 	RedirectView callbackLogin(@RequestParam("code") String authorizationCode){
		
		OAuth2Operations operations = factory.getOAuthOperations();
		
		// trả về thông tin quyền đăng nhập của người dùng
		AccessGrant accessToken = operations.exchangeForAccess(authorizationCode,"https://vti-aca-april-team1-api.herokuapp.com/callback",null );
		
		// tạo 1 kết nối đến facebook bằng acceessToken
		Connection<Facebook> connection = factory.createConnection(accessToken);
		Facebook facebook = connection.getApi();
		
		String[] fields = {"id","email","name","address"};// tên cột cần lấy
		 userProfile = facebook.fetchObject("me",User.class,fields); // lấy ra thông tin của người dùng
		
		boolean existsUser = userService.isExistsUserById(userProfile.getId()); // kiểm tra user đã tồn tại chưa
		if(!existsUser)
		{ 
			// nếu chưa tồn tại lưu vào db 
			UserDTO userDTO = new UserDTO(userProfile.getId(), userProfile.getName(), userProfile.getEmail()); 
			userService.createUser(userDTO.toEntity(userDTO));
		}
			// chuyển hướng về trang asean weather theo đường link bên dưới
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("http://aseanweather.herokuapp.com");
	    return redirectView ;
		}
	
	

	/**
	 * This method is get User Login Facebook.
	 * 
	 * @Description: .
	 * @author: Đinh Huy Khánh
	 * @create_date: 6/5/2021
	 * @version: 1.0
	 * @modifer: 
	 * @modifer_date: 
	 * @return : userProfile
	 */
	@GetMapping(value="/login/user")
	public User getUserLoginFacebook() {
		return userProfile;
	}

	
	
}
