package com.string.questions;

import java.util.HashMap;
import java.util.Map;
public class StringClass {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = new String("abc");
		
		if(s1.equals(s2))			
			System.out.println("true");
		
		//System.out.println(" "+Runtime.getRuntime().totalMemory());
		int[] myIntArray = {763,411,522,100,211,1328,184,311,100,100,646,1134,411};		
		int result = 0;
		for (int i=0;i<myIntArray.length;i++){
			result = result + myIntArray[i]; 
		}
		
		System.out.println(result);
		
		
		Map hashmap = new HashMap<>();
		
		//hashmap.put(s1, s2);
		//hashmap.put(s2, s1);
		Person p1 = new Person("name", "address", 20);
		Person p2 = new Person("name", "address", 20);
		Person p3 = new Person("nameA", "Aaddress", 20);
		hashmap.put(p1, "valueAAADDD");
		hashmap.put(p2, "valueBBB");
		System.out.println(hashmap.size());
		hashmap.put(p3,"ADDDDDDD");
		System.out.println(hashmap.size());
	}
}
 class Person {
	String name;
	String address;
	int num;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(String name, String address, int num) {
		super();
		this.name = name;
		this.address = address;
		this.num = num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		System.out.println("HashCode::; "+result);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
} 

 