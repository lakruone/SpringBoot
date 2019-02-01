package com.itamp.Service;

import java.sql.Date;
import java.util.List;
import com.itamp.Model.Child;

public interface ChildService {
	
	String add(Child child);

	Child get(String id);

	List<Child> all();

	void update(Child ch);

	void delete(String registrationId);

	String hin(String regId,Date dateOfBirth);

	
	

}
