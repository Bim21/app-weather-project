package com.vti.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping(value="/login/email={email}&password={password}")
	public ResponseEntity<Boolean> isExistsAdminByEmailAndPassword(
			@PathVariable(name="email") @NotBlank @Email String email, 
			@PathVariable(name="password") @NotBlank @Size(min=8, max=255, message = "Password should have min 8 characters") String password){
		
		
		return new ResponseEntity<Boolean>(service.isAdminExistsByEmailAndPassword(email, password), HttpStatus.OK);
	}
	
}
