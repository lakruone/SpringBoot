package com.itamp.ItampService;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itamp.Model.MOH;

public interface MOHRepository extends JpaRepository<MOH, Integer> {

	MOH findByName(String name);

}
