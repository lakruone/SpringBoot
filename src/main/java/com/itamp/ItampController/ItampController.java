package com.itamp.ItampController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ItampController {
	
	@Autowired
	private ChildService childService;
	@Autowired
    private UserService userService;
	@Autowired
    private LocationService locationService;
	//add one child
	 @RequestMapping(value="/child",consumes = "application/Json", method=RequestMethod.POST)
    public String add(@RequestBody Child child) {
    	return childService.add(child); 	   
    }
	
	//get all child
    @RequestMapping(value="/child",method=RequestMethod.GET)
    public List<Child> allchild() {
    return childService.all();
    }
    
    //get child by registrationid
	@RequestMapping(value="/child/{id}",method=RequestMethod.GET)
	public Child getchild(@PathVariable String id) {
	 return childService.get(id);
	 
	}
	//update child
	@RequestMapping(value="/child", consumes="application/json", method=RequestMethod.PUT)
	public void update(@RequestBody Child child) {
	  childService.update(child);
		 }
	
    @RequestMapping(value="/child/{registrationId}",method=RequestMethod.DELETE)
    public void delete(@PathVariable("registrationId") String registrationId) {
	  childService.delete(registrationId);
	             
    }
    
    //user controller
  //using username
  	@RequestMapping(value="/user/{username}" ,method=RequestMethod.GET)
  	public User getuser(@PathVariable("username") String username) {
  		 return  userService.get(username);
  		
  	}
  	
  	//add one user
  	@RequestMapping(value="/user", consumes = "application/json" ,method=RequestMethod.POST)
      public void add(@RequestBody User user) {
      	 userService.add(user); 	   
      }
  	
  	//get all users
      @RequestMapping(value="/user", method=RequestMethod.GET)
      public List<User> all() {
      return userService.all();
      }
      
     
      //login
      @RequestMapping(value="/user/login" ,consumes="application/json" ,method=RequestMethod.POST)
      public User login( @RequestBody User user) {
      	return userService.login(user.getUsername(),user.getPassword());
      	
      }
      
      //update user 
    /*  @PutMapping("/{id}")
      public String updateUser(@RequestBody User user,@PathVariable long id) {
      	return service.updateUser(user,id);
      }*/
      
      //delete user
      @RequestMapping(value="/user/{id}" , method=RequestMethod.DELETE)
      	public void delete(@PathVariable("id") Long id) {
      		userService.delete(id);
      }
      
      //location controller
      //get all rdhs area
      @RequestMapping(value="/rdhs",method=RequestMethod.GET)
  	private List<RDHS> rdhs(){
  		return locationService.findAll();
  	}
      //get ds area in one rdhs
     @RequestMapping(value="/dsrdhs/{name}", method=RequestMethod.GET)
     private List<DS> dsAreaInOneRdhs(@PathVariable String name ){
    	 return locationService.dsAreaInOneRdhs(name);
     }
     //get moh areas in one ds
     @RequestMapping(value="/mohds{name}" ,method=RequestMethod.GET)
     private List<MOH> mohAreaINOneDs(@PathVariable String name){
    	 return locationService.mohAreaInOneDs(name);
     }
     //get phm area in one moh
     @RequestMapping(value="/pgmmoh{name}" ,method=RequestMethod.GET)
     private List<PHM> phmAreaINOneMoh(@PathVariable String name){
    	 return locationService.phmAreaInOneMoh(name);
     }
     //get gn area in one phm 
     @RequestMapping(value="/gnphm{name}" ,method=RequestMethod.GET)
     private List<GN> gnAreaInOnePhm(@PathVariable String name){
    	 return locationService.gnAreaInOnePhm(name);
     }
     
    
     } 
