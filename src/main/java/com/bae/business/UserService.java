package com.bae.business;

import java.util.List;

import com.bae.persistence.domain.User;

public interface UserService {
	public String createUser(User user);

	public List<User> getAllUsers();

	public User findUserByMemberId(int memberId);

}