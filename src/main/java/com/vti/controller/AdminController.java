package com.vti.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.vti.entity.Admin;
import com.vti.service.IAdminService;

@RestController
@RequestMapping(value="api/v1/admin")
@CrossOrigin("*")
@Validated
public class AdminController {
	
	@Autowired
	private IAdminService service;
	
	/**
	 * This method is AdminExistsByEmailAndPassword
	 * 
	 * @Description: .
	 * @author: Đinh Huy Khánh
	 * @create_date: 3/5/2021
	 * @version: 1.0
	 * @modifer: 
	 * @modifer_date: 
	 */
	
	@PostMapping(value="/login")
	public Map<String,String> LoginAdmin(@RequestBody Admin admin){
			
			HashMap<String, String> map = new HashMap<>();
			if(!service.isAdminExistsByEmailAndPassword(admin.getEmail(), admin.getPassword())) {
				map.put("email",admin.getEmail());
				map.put("status", "200");
				map.put("message", "Account does not exist");
				return map;
			}
			map.put("email",admin.getEmail());
			map.put("status", "200");
			map.put("message", "Success");
			
			return map;
	}
	
}
