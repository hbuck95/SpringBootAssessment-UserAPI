package com.bae.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.business.UserService;
import com.bae.persistence.domain.User;

@RestController
@RequestMapping("/user")
public class UserController {
	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/memberid/{id}")
	public User findByMemberId(@PathVariable("id") int id) {
		return service.findUserByMemberId(id);
	}

	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		return service.createUser(user);
	}

}
