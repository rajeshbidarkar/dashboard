package com.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.models.MResource;

public interface ResourcesRepository extends  JpaRepository<MResource, Long> {

	public List<MResource> findByUser(String user);
	 
    public MResource findById(Long id);
	
}
