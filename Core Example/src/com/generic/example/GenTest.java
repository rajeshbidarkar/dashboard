package com.generic.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenTest {

	public static void main(String[] args) {
		
		final List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		
Collections.unmodifiableList(list);
		
		display(list);
		a(null);
		a(5);
		a("");
		System.out.println(list);
	}
	
	public static void display(List list){
		list.add("aa");
		list.add("55");
		System.out.println(list);
	}
	
	public static void a(Object o){
		
		System.out.println("obj"+o);
	}
    public static void a(String o){
    	System.out.println("STR"+o);
	}
}
