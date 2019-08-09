package com.bae.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.User;
import com.bae.persistence.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	private static final User MOCK_USER_A = new User(1, "Fred", 1);
	private static final User MOCK_USER_B = new User(2, "Bob", 2);
	private static final String MOCK_CREATE_USER_RESPONSE = "User created!";

	@InjectMocks
	private UserServiceImpl service;

	@Mock
	private UserRepository repo;

	private List<User> userList;

	@Before
	public void setup() {
		userList = new ArrayList<>();
	}

	@Test
	public void getAllUsersTest() {
		userList.add(MOCK_USER_A);
		userList.add(MOCK_USER_B);

		Mockito.when(repo.findAll()).thenReturn(userList);

		List<User> res = service.getAllUsers();

		Mockito.verify(repo).findAll();
		assertEquals(userList, res);
	}

	@Test
	public void findMemberByIdTest() {
		Mockito.when(repo.findByMemberId(1)).thenReturn(MOCK_USER_A);
		User user = service.findUserByMemberId(1);
		Mockito.verify(repo).findByMemberId(1);
		assertEquals(user, MOCK_USER_A);
		assertEquals(1, MOCK_USER_A.getMemberId());
	}

}
