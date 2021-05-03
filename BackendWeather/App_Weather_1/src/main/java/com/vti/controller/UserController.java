package com.vti.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.service.IUserService;

@RestController
@RequestMapping(value="api/v1/users")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

	@Autowired
	private IUserService service;
	
	@GetMapping(value = "/exists?id={id}")
	public ResponseEntity<Boolean> isExistsUserById(@PathVariable(name="id") String id){
		
		return new ResponseEntity<Boolean>(service.isExistsUserById(id),HttpStatus.OK);
	}
	
	
}
