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

import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping(value = "api/v1/ip")
@CrossOrigin("*")
public class IPPublicController {

	private static int count=0;
	
	@Autowired 
	private IIPPublicService service;
	
	@GetMapping()
	public ResponseJwt isTotalViews() throws UnknownHostException {
		setCount(++count);
		ResponseJwt result = new ResponseJwt();
		Map<String, Object> map = new HashMap<>();
		InetAddress address = (InetAddress) InetAddress.getLocalHost();
		
		String ipAddress = address.getHostAddress();
		
		if(!service.isExistsByIpPublic(ipAddress)) {
			IPPublic entity = new IPPublic(ipAddress);
			service.createIpPublic(entity);
		}
		
		map.put("ip", ipAddress);
		map.put("count",this.getCount());
		result.setMessage("Success");
		result.setData(map);
		
		return result;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		IPPublicController.count = count;
	}
	
	
}
