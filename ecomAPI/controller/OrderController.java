package com.ecomapi.ecomAPI.controller;

import java.util.Optional;

import com.ecomapi.ecomAPI.model.*;
import com.ecomapi.ecomAPI.repository.AddressRepository;
import com.ecomapi.ecomAPI.repository.ProductRepository;
import com.ecomapi.ecomAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomapi.ecomAPI.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/get-order/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
	    Order existingOrder = orderRepository.getOrderById(id);
	    if (existingOrder!=null) {
	        return ResponseEntity.ok(existingOrder);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
//	@PostMapping("/create")
//	public Order createOrder(@RequestBody Order order) {
//	    return orderRepository.save(order);
//	}

	//create new order
	@PostMapping("/create-order/{userId}/{addressId}/{productId}")
	public ResponseEntity<String> createNewOrder(@PathVariable Integer userId,
												               Integer addressId,
												               Integer productId,
												 @RequestBody Order order){
		User existingUser = userRepository.getUserById(userId);
		Address existingAddress = addressRepository.getAddressById(addressId);
		Product existingProduct = productRepository.getProductById(productId);
		if(existingUser != null && existingAddress != null && existingProduct != null){
			order.setAddress(existingAddress);
			order.setUser(existingUser);
			order.setProduct(existingProduct);
			orderRepository.save(order);
			return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
		}else{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
		}
	}

}
