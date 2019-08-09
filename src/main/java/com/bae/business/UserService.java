package com.bae.business;

import com.bae.persistence.domain.User;

public interface UserService {
	public String createUser(String user);

	public User findUserByMemberId(int memberId);

}
