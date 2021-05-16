package com.vti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.IPPublic;
import com.vti.service.IIPPublicService;
import com.vti.utils.ResponseJwt;

@RestController
@RequestMapping(value = "api/v1/ip")
@CrossOrigin("*")
public class IPPublicController {

	@Autowired 
	private IIPPublicService service;
	
	@PostMapping(value="/count")
	public ResponseJwt isTotalView(@RequestBody IPPublic ip) {
		ResponseJwt result = new ResponseJwt();
		Map<String, Object> map = new HashMap<>();
		
		
		if(!service.isExistsByIpPublic(ip.getIpPublic())) {
			IPPublic entity = new IPPublic(ip.getIpPublic());
			service.createIpPublic(entity);
		}
		
		map.put("count", IPPublic.getCount());
		result.setMessage("Success");
		result.setData(map);
		
		return result;
	}
}
