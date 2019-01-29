package com.itamp.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itamp.ExceptionHandle.UserException;
import com.itamp.ItampService.UserRepository;
import com.itamp.Model.User;
import com.itamp.Service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void add(User user) {
		userRepository.save(user);	
	}

	@Override
	public User login(String username , String password) {
		User us= userRepository.findByUsername(username);
		if(us ==null || !us.getPassword().equals(password)) {
			 throw new UserException();
		}
		else return us;
		
	}
	
	@Override
	public List<User> all() {
		List<User> user=userRepository.findAll();
		return user;
	}
	
	@Override
	public User get(String username) {
		User user=userRepository.findByUsername(username);
		if(user == null)throw new UserException();	
		return user;
	}
	
	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	    
	}

}
