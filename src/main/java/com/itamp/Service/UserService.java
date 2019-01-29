package com.itamp.Service;

import java.util.List;

import com.itamp.Model.User;

public interface UserService {
	void add(User user);
	User login(String username, String password);
	User get(String username);
	List<User> all();
	void delete(Long id);

}
