package com.dominos.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominos.user.entity.User;
import com.dominos.user.exception.custom.DuplicateEmailException;
import com.dominos.user.exception.custom.UserNotFoundException;
import com.dominos.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {

		if (userRepository.existsByEmail(user.getEmail())) {
			throw new DuplicateEmailException("Email already exists");
		}
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(Long id, User user) {

		User existing = getUserById(id);
		existing.setName(user.getName());
		existing.setMobile(user.getMobile());
		existing.setRole(user.getRole());
		existing.setActive(user.getActive());

		return userRepository.save(existing);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(getUserById(id));
	}
}
