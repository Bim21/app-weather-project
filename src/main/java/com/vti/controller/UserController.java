package com.vti.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.City;
import com.vti.entity.User;
import com.vti.service.IUserService;


@RestController
@RequestMapping(value = "api/v1/users")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "id/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(name = "id") String id) {		
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/exists?id={id}")
	public ResponseEntity<Boolean> isExistsUserById(@PathVariable(name="id") String id){
		
		return new ResponseEntity<Boolean>(userService.isExistsUserById(id),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUser(){	
		List<User> entities = userService.getAllUsers();	
		return new ResponseEntity<List<User>>(entities,HttpStatus.OK);
	}
	
	
}
