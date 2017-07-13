package com.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.models.SOWMaster;

public interface SOWRepository extends  JpaRepository<SOWMaster, Long> {

	public List<SOWMaster> findByUser(String user);
	 
    public SOWMaster findById(Long id);
	
}
