package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AddressRequest;
import com.example.demo.dao.AddressResponses;
import com.example.demo.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/create")
	private AddressResponses createAddress(@RequestBody AddressRequest address) {
		AddressResponses addressResponse = addressService.getAddressService(address);
		return addressResponse;
	}
	
	@GetMapping("/get/{id}")
	private AddressResponses getAddress(@PathVariable("id") Long id) {
		return addressService.getAddress(id);
	}

}
