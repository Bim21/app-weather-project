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
	
	/**
	 * This method is TotalViews
	 * 
	 * @Description: .
	 * @author: Đinh Huy Khánh
	 * @create_date: 15/5/2021
	 * @version: 1.0
	 * @modifer: 
	 * @modifer_date: 
	 * return : result (json) 
	 */
	@GetMapping()
	public ResponseJwt isTotalViews() throws UnknownHostException {
		setCount(++count); // biến count tăng lên
		ResponseJwt result = new ResponseJwt();
		Map<String, Object> map = new HashMap<>();
		InetAddress address = (InetAddress) InetAddress.getLocalHost();
		
		String ipAddress = address.getHostAddress();
		
		if(!service.isExistsByIpPublic(ipAddress)) { // nếu ip này chưa tồn tại  thì lưu vào database
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
