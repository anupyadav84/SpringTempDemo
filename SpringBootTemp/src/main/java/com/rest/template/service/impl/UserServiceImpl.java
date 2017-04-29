package com.rest.template.service.impl;

import org.springframework.stereotype.Service;

import com.rest.template.model.User;
import com.rest.template.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User create(User user) {
		return user;
	}

	@Override
	public User get(String userId) {
		
		User user = new User();
		user.setId("123456");
		user.setFirstName("Anup");
		user.setLastName("Yadav");
		return user;
	}

	@Override
	public void update(User user) {

	}

	@Override
	public void delete(String userId) {

	}

}
