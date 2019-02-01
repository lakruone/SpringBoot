package com.itamp.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.itamp.ExceptionHandle.UserException;
import com.itamp.ExceptionHandle.UserRegisterException;
import com.itamp.ItampService.UserRepository;
import com.itamp.Model.Role;
import com.itamp.Model.User;
import com.itamp.Service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	User user=new User();
	//user add
	@Override
	public void add(User user){
		try {
		userRepository.save(user);
		}
		catch(Exception e) {
			  throw new UserRegisterException();
		}
		
	}	
	@Override
	public ResponseEntity<User> login(String username , String password) {
		User us= userRepository.findByUsername(username);
		if(us ==null || !us.getPassword().equals(password)) {
			 throw new UserException();
		}
		else return ResponseEntity.ok(us);
		
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
	//update
	@Override
	public String updateUser(User us,Long id) {
		User user=userRepository.findById(id);
		Role role=userRepository.findById(id).getRole();
       if(user!=null) {
    	   user.setId(id);
    	   user.setUsername(us.getUsername());
    	   user.setFirstname(us.getFirstname());
    	   user.setLastName(us.getLastName());
    	   user.setPassword(us.getPassword());
    	   user.setContactNo(us.getContactNo());
    	   user.setEmail(us.getEmail());
    	   role.setRoleId(user.getRole().getRoleId());
    	   role.setPrivilege(user.getRole().getPrivilege());
    	   role.setRole(user.getRole().getRole());
    	   user.setRole(role);
    	   System.out.println(user.toString());
    	   userRepository.save(user);
    	   
    	   return "successfully update";
       }
       else
    	   throw new UserException();
    	   
    }
}
