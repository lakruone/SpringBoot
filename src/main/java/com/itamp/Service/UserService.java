package com.itamp.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.itamp.Model.User;

public interface UserService {
	void add(User user);
	ResponseEntity<User> login(String username, String password);
	User get(String username);
	List<User> all();
	void delete(Long id);
	String updateUser(User user,Long id);
}
