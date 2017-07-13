package com.spring.controller;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Util  {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

		
	protected EntityManagerFactory getEntityManagerFactory() {
		
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}	
	
	public static Date getLastDateOfMonth(){
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.add(Calendar.MONTH, 2);  
		aCalendar.set(Calendar.DAY_OF_MONTH, 1);  
		aCalendar.add(Calendar.DATE, -1);
        java.util.Date date = new java.util.Date();
		date =aCalendar.getTime();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());		
		return sqlDate;
	}	
	
	public static Date getTodayDate(){
		Calendar aCalendar = Calendar.getInstance();
		java.util.Date date = new java.util.Date();
		date =aCalendar.getTime();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());		
		return sqlDate;
	}
}
