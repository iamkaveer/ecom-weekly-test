package com.ecomapi.ecomAPI.controller;

import java.util.List;
import java.util.Optional;

import com.ecomapi.ecomAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomapi.ecomAPI.model.Address;
import com.ecomapi.ecomAPI.repository.AddressRepository;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	private AddressRepository addressRepository;

	@PostMapping("/create-address")
	public ResponseEntity<Address> createUser(@RequestBody Address address) {
		return new ResponseEntity<>(addressRepository.save((address)), HttpStatus.CREATED);
	}
}
