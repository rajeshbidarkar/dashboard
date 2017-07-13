package com.generic.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GenericClass<T> {
	Set <T> set = new HashSet<T>();
	public void addOb(T t){
		set.add(t);
	} 
	public void deleteOb(T t){
		set.remove(t);
	}
	public Iterator<T> getIterator(){
		return set.iterator();
	}
}
