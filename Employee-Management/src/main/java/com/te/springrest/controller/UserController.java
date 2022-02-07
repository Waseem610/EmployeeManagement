package com.te.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.springrest.model.UserResponse;
import com.te.springrest.model.User_Info;
import com.te.springrest.service.UserServiceImpl;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	UserServiceImpl service;

	@PostMapping("register")
	public ResponseEntity<UserResponse> register(@RequestBody User_Info info) {
		User_Info register = service.register(info);
		UserResponse userResponse = new UserResponse();
		if (register == null) {
			userResponse.setError(true);
			userResponse.setData("Invalid info");
		}
		userResponse.setError(false);
		userResponse.setData(register);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
	@PostMapping("login")
	public ResponseEntity<UserResponse> login(@RequestParam String userName, @RequestParam String password) {
		User_Info login = service.login(userName, password);
		UserResponse userResponse = new UserResponse();
		if (login == null) {
			userResponse.setError(true);
			userResponse.setData("Invalid info");
		}
		userResponse.setError(false);
		userResponse.setData(login);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
	@PostMapping("forgotPassword")
	public ResponseEntity<UserResponse> forgotPassword(@RequestParam String email, @RequestParam String password){
		User_Info forgotPassword = service.forgotPassword(email, password);
		UserResponse userResponse = new UserResponse();
		if (forgotPassword == null) {
			userResponse.setError(true);
			userResponse.setData("Invalid info");
		}
		userResponse.setError(false);
		userResponse.setData(forgotPassword);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
		
	}

}
