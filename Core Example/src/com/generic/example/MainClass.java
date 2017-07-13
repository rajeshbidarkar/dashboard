package com.generic.example;

import java.util.HashSet;
import java.util.Set;

public class MainClass {
	public static void main(String[] args) {
		Set <Base> set = new HashSet<Base>();		
		
		
		set.add(new Derive1());
		set.add(new Derive2());
		set.add(new Base());
		for(Base b : set){
			Base B = b;
			
		}
		
		GenericClass<Derive1> gc = new GenericClass<Derive1>();
		
		gc.addOb(new Derive1());
		
	}
}
