package com.bae.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.domain.User;
import com.bae.persistence.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository repo;

	private static final User MOCK_USER_A = new User(1, "Fred", 1);
	private static final User MOCK_USER_B = new User(2, "Bob", 2);
	private static final String MOCK_CREATE_USER_RESPONSE = "User created!";

	@Autowired
	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public String createUser(User user) {
		repo.save(user);
		return "User created!";
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
