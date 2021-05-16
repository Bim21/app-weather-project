package com.vti.controller;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value="/count")
	public ResponseJwt isTotalViews() throws UnknownHostException {
		
		ResponseJwt result = new ResponseJwt();
		Map<String, Object> map = new HashMap<>();
		InetAddress address = (InetAddress) InetAddress.getLocalHost();
		
		String ipAddress = address.getHostAddress();
		
		if(!service.isExistsByIpPublic(ipAddress)) {
			IPPublic entity = new IPPublic(ipAddress);
			service.createIpPublic(entity);
		}
		
		map.put("count", service.countByIpPublic());
		result.setMessage("Success");
		result.setData(map);
		
		return result;
	}
}
