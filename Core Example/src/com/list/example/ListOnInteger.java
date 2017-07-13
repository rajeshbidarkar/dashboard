package com.list.example;
import java.util.ArrayList;
import java.util.List;

public class ListOnInteger {

	public static void main(String[] args) {
		final List<Integer> modifiable = new ArrayList<>();
		modifiable.add(1);
		modifiable.add(2);
		
		System.out.println("Before modification: " + modifiable);

		modifiable.add(3);
		modifiable.add(4);

		
		modifiable.remove(new Integer(3));
		
		
		System.out.println("After modification: " + modifiable);
		

	}

}
