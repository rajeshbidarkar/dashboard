package com.inheritance.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ContactList {
	Set<Contact> contactset = new HashSet<Contact>();	
	
	private static ContactList instance = null; 
	
	public static ContactList getInstance() {
		if(instance==null) {
			instance = new ContactList();
		}
		return instance ;		
	}

	private ContactList(){
		
	}
	
	public void addContact(String name, int num) {
		contactset.add(new Contact(name, num));		
	}
	
	public int getNumber(String name) throws Exception {
		Iterator<Contact> it = contactset.iterator();
		while(it.hasNext()){
			Contact obj = it.next();
			if(obj.getName().equalsIgnoreCase(name)){
				return obj.getNumber();
			}
		}
		throw new Exception("Number not forund.....");
	}
	
	public String getNumber(int num) throws Exception {
		
		Iterator<Contact> it = contactset.iterator();
		while(it.hasNext()){
			Contact obj = it.next();
			if(obj.getNumber()==num){
				return obj.getName();
			}
		}
		throw new Exception("Name not forund.....");
	}
	
	public String voiewAllContacts(){
		return contactset.toString();
	} 
	public static void main(String[] args) throws Exception {
		ContactList list = ContactList.getInstance();
		list.addContact("Rajesh", 124568);		
		System.out.println(list.getNumber("rajesh"));
	}
}
