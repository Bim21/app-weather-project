package com.vti.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Admin;
import com.vti.service.IAdminService;
import com.vti.utils.ResponseJwt;

@RestController
@RequestMapping(value="api/v1/admin")
@CrossOrigin("*")
@Validated
public class AdminController {
	
	@Autowired
	private IAdminService service;
	
	/**
	 * This method is loginAdmin
	 * 
	 * @Description: .
	 * @author: Đinh Huy Khánh
	 * @create_date: 3/5/2021
	 * @version: 1.0
	 * @modifer: 
	 * @modifer_date: 
	 * return : result (json) 
	 */
	
	@PostMapping(value="/login")
	public ResponseJwt loginAdmin(@RequestBody @Valid  Admin admin){
			ResponseJwt result = new ResponseJwt();
			HashMap<String, String> map = new HashMap<>();
			
			if(!service.isAdminExistsByEmailAndPassword(admin.getEmail(), admin.getPassword())) {
				map.put("email",admin.getEmail());
				result.setData(map);
				result.setMessage("Account does not exist");
				return result;
			}
			
			map.put("email",admin.getEmail());
			result.setData(map);
			result.setMessage("Success");
			return result;
	}
	
}
