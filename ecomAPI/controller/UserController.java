package com.ecomapi.ecomAPI.controller;

import java.util.List;
import java.util.Optional;

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

import com.ecomapi.ecomAPI.model.User;
import com.ecomapi.ecomAPI.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private UserRepository userRepository;

	//get by user id
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
	    User existingUser = userRepository.findById(id).get();
		if(existingUser!=null){
			return ResponseEntity.ok(existingUser);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	//create a new user
	@PostMapping("/create-user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<>(userRepository.save((user)), HttpStatus.CREATED);
	}
}
