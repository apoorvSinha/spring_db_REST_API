package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	//https://localhost:8080/users
	//https://localhost:8080/users/userID	--userid is path parameter
	//https://localhost:8080/users?page=1&limit=50	--page and limit are query parameters
	
	@GetMapping
	public String getUser(@RequestParam(value="page") int pageno, @RequestParam(value="limit") int limitno) {
		
		return "http GET request was sent for page: "+ pageno+ "and limit: "+ limitno ;
	}
	@GetMapping(path="/{userID}")
	public String getUser1(@PathVariable String userID) {
		
		return "http GET request was sent for userid: "+ userID;
	}
	@PostMapping
	public String CreateUser() {
		
		return "http POST request was sent";
	}
	@PutMapping
	public String updateUser() {
		
		return "http put request was sent";
	}
	@DeleteMapping
	public String deleteUser() {
		
		return "http delete request was sent";
	}
	
	
}
