package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddressRequest;
import com.example.demo.dao.AddressResponses;
import com.example.demo.dao.AddressDao;
import com.example.demo.dao.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	 public AddressResponses getAddressService(AddressRequest address) {
		 AddressDao input = new AddressDao();
		 input.setLocation(address.getLocation());
		 input.setState(address.getState());
		AddressDao add = addressRepository.save(input);
		AddressResponses addressResponse = new AddressResponses();
		//addressResponse.setId(add.getId());
		addressResponse.setLocation(add.getLocation());
		addressResponse.setState(add.getState());
		return addressResponse;
	}
	 
	 public AddressResponses getAddress(Long id) {
		 Optional<AddressDao> address = addressRepository.findById(id);
		 AddressResponses addressResponses = new AddressResponses();
		 addressResponses.setId(address.get().getId());
		 addressResponses.setLocation(address.get().getLocation());
		 addressResponses.setState(address.get().getState());
		 return addressResponses;
	 }
}
