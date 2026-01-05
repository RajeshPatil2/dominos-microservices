package com.dominos.user.service;

import java.util.List;

import com.dominos.user.entity.User;

public interface UserService {

	User createUser(User user);

	User getUserById(Long id);

	List<User> getAllUsers();

	User updateUser(Long id, User user);

	void deleteUser(Long id);
}
