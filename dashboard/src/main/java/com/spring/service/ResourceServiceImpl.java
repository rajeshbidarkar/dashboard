package com.spring.service;

import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.models.MResource;
import com.spring.repository.ResourcesRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ResourceServiceImpl implements ResourceService{
	
	@Resource
	private ResourcesRepository resourcesRepository;

	@Override
	@Transactional
	public MResource create(MResource resource) {
		return resourcesRepository.save(resource);
	}

	@Override
	@Transactional
	public List<MResource> findByUserId(String id) {
		List<MResource> resources = resourcesRepository.findByUser(id);
		Collections.sort(resources, MResource.ResourceNameComparator);
		return resources;
	}

	@Override
	@Transactional(rollbackFor=ObjectNotFoundException.class)
	public MResource delete(Long id) throws ObjectNotFoundException {
		MResource deletedResource = resourcesRepository.findOne(id);
		
		if (deletedResource == null)
			throw new ObjectNotFoundException("No Element Found");
		deletedResource.setSow(null);
		resourcesRepository.delete(deletedResource);
		return deletedResource;
	}

	@Override
	@Transactional
	public List findAll() {
		return resourcesRepository.findAll();
	}


	@Override
	public List<MResource> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MResource> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Long id) {
		return resourcesRepository.exists(id);
	}

}
