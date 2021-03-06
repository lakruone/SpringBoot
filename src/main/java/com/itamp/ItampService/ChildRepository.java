package com.itamp.ItampService;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itamp.Model.Child;

public interface ChildRepository extends JpaRepository<Child, Long> {

	Child findByRegistrationId(String registrationId);
	boolean deleteByRegistrationId(String id);
	
    
}
