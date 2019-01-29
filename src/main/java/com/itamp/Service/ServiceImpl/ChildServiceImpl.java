package com.itamp.Service.ServiceImpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itamp.ExceptionHandle.ItemNotFoundException;
import com.itamp.ItampService.ChildRepository;
import com.itamp.Model.Child;
import com.itamp.Service.ChildService;

@Service 
public class ChildServiceImpl implements ChildService {
	@Autowired
	private ChildRepository childRepository;
	
	//add child
	@Override
	public String add(Child child) {
	     childRepository.saveAndFlush(child);
		return null;
	}
      //get all child
	@Override
	public List<Child> all() {
	   List<Child> child=childRepository.findAll();
	   return child;
	}
	
	//get a child
	@Override
	public Child get(String regiId){
	   Child child=childRepository.findByRegistrationId(regiId);
	   if(child==null)throw new ItemNotFoundException(); 
	   return child;
	}
	
	//update child
	@Override
	public void update(Child child) {
		try {
		childRepository.save(child);
		}
		catch(ItemNotFoundException ex) {
			throw new ItemNotFoundException();
		}
	}
	
	//delete child
	@Override
	public void delete(String id){
	   Long childid=childRepository.findByRegistrationId(id).getChildId();
	   try {
		   childRepository.delete(childid);	  
	   }
	   catch(Exception ex) {
		   throw new ItemNotFoundException();
	   }
	   
	}
	
	
	
}
