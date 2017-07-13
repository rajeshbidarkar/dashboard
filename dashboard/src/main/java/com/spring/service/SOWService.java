package com.spring.service;

import java.util.List;
import com.spring.models.SOWMaster;

import javassist.tools.rmi.ObjectNotFoundException;

public interface SOWService {
	
	SOWMaster create(SOWMaster sowmaster);
	SOWMaster delete(Long id) throws ObjectNotFoundException;
	List<SOWMaster> findAll();
	List<SOWMaster> findById(Long id);
	List<SOWMaster> findById(String id);
	List<SOWMaster> findByUserId(String id);
	boolean isExist(Long id);

}
