package com.spring.service;

import java.util.List;

import com.spring.models.MResource;

import javassist.tools.rmi.ObjectNotFoundException;

public interface ResourceService {
	
	MResource create(MResource resource);
	MResource delete(Long id) throws ObjectNotFoundException;
	List<MResource> findAll();
	List<MResource> findById(Long id);
	List<MResource> findById(String id);
	List<MResource> findByUserId(String id);
	boolean isExist(Long id);

}
