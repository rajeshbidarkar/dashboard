package com.spring.service;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Column;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.models.Contact;
import com.spring.repository.ContactsRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Resource
	private ContactsRepository contactsRepository;

	@Override
	@Transactional
	public Contact create(Contact contact) {
		if(contact.getId()!=null){
			Contact c = contactsRepository.getOne(contact.getId());			
			c.setId(contact.getId());
			c.setVp(contact.getVp());
			c.setDirector(contact.getDirector());
			c.setEmailid(contact.getEmailid());
			c.setSenior_manager(contact.getSenior_manager());
			c.setSvp(contact.getSvp());
			c.setEmailtosendinvoice(contact.getEmailtosendinvoice());
			c.setDepartment_name(contact.getDepartment_name());			
			return contactsRepository.save(c);
		}
		else
		return contactsRepository.save(contact);
	}

	@Override
	@Transactional
	public List<Contact> findByUserId(String id) {
		List<Contact> contacts = contactsRepository.findByUser(id);
		Collections.sort(contacts,Contact.ContactNameComparator);
		return contacts;
	}

	@Override
	@Transactional(rollbackFor=ObjectNotFoundException.class)
	public Contact delete(Long id) throws ObjectNotFoundException {
		Contact deletedContact = contactsRepository.findOne(id);
		
		if (deletedContact == null)
			throw new ObjectNotFoundException("No Element Found");

		contactsRepository.delete(deletedContact);
		return deletedContact;
	}

	@Override
	@Transactional
	public List findAll() {
		return contactsRepository.findAll();
	}


	@Override
	public List<Contact> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Long id) {
		return false;
	}

}
