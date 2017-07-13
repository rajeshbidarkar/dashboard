package com.spring.service;

import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.models.SOWMaster;
import com.spring.repository.SOWRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class SOWServiceImpl implements SOWService{
	
	@Resource
	private SOWRepository sowRepository;

	@Override
	@Transactional
	public SOWMaster create(SOWMaster sowmaster) {
		return sowRepository.save(sowmaster);
	}

	@Override
	@Transactional
	public List<SOWMaster> findByUserId(String id) {
		List<SOWMaster> sows = sowRepository.findByUser(id);
		Collections.sort(sows, SOWMaster.SOWIdComparator);
		return sows;
	}

	@Override
	@Transactional(rollbackFor=ObjectNotFoundException.class)
	public SOWMaster delete(Long id) throws ObjectNotFoundException {
		SOWMaster deletedSOW = sowRepository.findOne(id);
		
		if (deletedSOW == null)
			throw new ObjectNotFoundException("No Element Found");
		deletedSOW.setAssociates(null);
		sowRepository.delete(deletedSOW);
		return deletedSOW;
	}

	@Override
	@Transactional
	public List findAll() {
		return sowRepository.findAll();
	}


	@Override
	public List<SOWMaster> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SOWMaster> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Long id) {
		return sowRepository.exists(id);
	}	
	
}
