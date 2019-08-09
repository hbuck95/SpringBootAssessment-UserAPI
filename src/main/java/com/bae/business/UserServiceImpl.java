package com.bae.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bae.persistence.domain.User;
import com.bae.persistence.repository.UserRepository;

public class UserServiceImpl implements UserService {
	private UserRepository repo;

	@Autowired
	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public String createUser(User user) {
		repo.save(user);
		return "User create!";
	}

	@Override
	public User findUserByMemberId(int memberId) {
		return repo.findByMemberId(memberId);
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

}
