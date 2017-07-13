package com.list.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifyableList {

	public static void main(String[] args) {
		final List<String> modifiable = new ArrayList<>();
		modifiable.add("Java");
		modifiable.add("is");

		// Here we are creating a new array list
		final List<String> unmodifiable = Collections.unmodifiableList(new ArrayList<>(modifiable));
		System.out.println("Before modification: " + unmodifiable);

		modifiable.add("the");
		modifiable.add("best");

		System.out.println("After modification: " + unmodifiable);

	}

}
