package com.itamp.ItampController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itamp.Model.Child;
import com.itamp.Model.DS;
import com.itamp.Model.GN;
import com.itamp.Model.MOH;
import com.itamp.Model.PHM;
import com.itamp.Model.RDHS;
import com.itamp.Model.User;
import com.itamp.Service.ChildService;
import com.itamp.Service.LocationService;
import com.itamp.Service.UserService;

@CrossOrigin(origins = "http://localhost:4200" ,maxAge= 3600)
@RequestMapping("/api")
@RestController
public class ItampController {
	

	@Autowired
	private ChildService childService;
	@Autowired
    private UserService userService;
	@Autowired
    private LocationService locationService;
	//add one child
	 @PostMapping(value="/child",consumes = "application/Json")
    public String add(@RequestBody Child child) {
    	return childService.add(child); 	   
    }
	
	//get all child
    @GetMapping("/child")
    public List<Child> allchild() {
    return childService.all();
    }
    
    //get child by registrationid
	@GetMapping("/child/{id}")
	public Child getchild(@PathVariable String id) {
	 return childService.get(id);
	 
	}
	//update child
	@PutMapping(value="/child/{id}", consumes="application/json")
	public void update(@RequestBody Child child) {
	  childService.update(child);
		 }
	
    @DeleteMapping("/child/{registrationId}")
    public void delete(@PathVariable("registrationId") String registrationId) {
	  childService.delete(registrationId);
	             
    }
    
    //user controller
  //using username
  	@GetMapping("/user/{username}")
  	public User getuser(@PathVariable("username") String username) {
  		 return  userService.get(username);
  		
  	}
  	
  	//add one user
  	@PostMapping(value="/user", consumes = "application/json")
      public void add(@RequestBody User user) {
      	 userService.add(user); 	   
      }
  	
  	//get all users
      @GetMapping("/user")
      public List<User> all() {
      return userService.all();
      }
      
     
      //login
      @PostMapping(value="/login" ,consumes="application/json" )
      public ResponseEntity<User> login( @RequestBody User user) {
    	  System.out.println("usrname  -->"+user.getUsername());
      	return userService.login(user.getUsername(),user.getPassword());
      	
      }
      
      
      //update user 
      @PutMapping("/user/{id}" )
      public String updateUser(@RequestBody User user,@PathVariable Long id) {
      	return userService.updateUser(user , id);
      }
      
      //delete user
      @DeleteMapping("/user/{id}")
      	public void delete(@PathVariable("id") Long id) {
      		userService.delete(id);
      }
      
      //location controller
      //get all rdhs area
      @GetMapping("/rdhs")
  	private List<RDHS> rdhs(){
  		return locationService.findAll();
  	}
      //get ds area in one rdhs
     @GetMapping("/dsrdhs/{name}")
     private List<DS> dsAreaInOneRdhs(@PathVariable String name ){
    	 return locationService.dsAreaInOneRdhs(name);
     }
     //get moh areas in one ds
     @GetMapping("/mohds{name}")
     private List<MOH> mohAreaINOneDs(@PathVariable String name){
    	 return locationService.mohAreaInOneDs(name);
     }
     //get phm area in one moh
     @GetMapping("/pgmmoh{name}")
     private List<PHM> phmAreaINOneMoh(@PathVariable String name){
    	 return locationService.phmAreaInOneMoh(name);
     }
     //get gn area in one phm 
     @GetMapping("/gnphm{name}")
     private List<GN> gnAreaInOnePhm(@PathVariable String name){
    	 return locationService.gnAreaInOnePhm(name);
     }
     
    
     } 
