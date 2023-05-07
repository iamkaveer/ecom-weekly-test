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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomapi.ecomAPI.model.Product;
import com.ecomapi.ecomAPI.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/get-product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
	    Product existingProduct = productRepository.getProductById(id);
		if(existingProduct!=null){
			return ResponseEntity.ok(existingProduct);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/create-product")
	public ResponseEntity<Product> createUser(@RequestBody Product product) {
		return new ResponseEntity<>(productRepository.save((product)), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete-product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
		Product existingProduct = productRepository.getProductById(id);
		if(existingProduct!=null){
			productRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("DELETED");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
		}
	}
	
	@GetMapping(params = "category")
	public List<Product> getProductsByCategory(@RequestParam String category) {
	    return productRepository.findByCategory(category);
	}
}
