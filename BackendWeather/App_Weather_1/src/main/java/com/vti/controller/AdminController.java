package com.vti.controller;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.service.IAdminService;

@RestController
@RequestMapping(value="api/v1/admin")
@CrossOrigin(origins = "http://localhost:8080")

public class AdminController {
	
	@Autowired(required=true)
	private IAdminService service;
	
	@GetMapping(value="/login/email={email}&password={password}")
	public ResponseEntity<Boolean> isAdminExistsByEmailAndPassword(@PathVariable(name="email") @Email String email, @PathVariable(name="password") @Length(min = 8) String password){
			
		return new ResponseEntity<Boolean>(service.isAdminExistsByEmailAndPassword(email, password), HttpStatus.OK);
	}
}
