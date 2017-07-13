package com.immutable.example;

public class MainEmployee {

	public static void main(String[] args) {
		Address address =  new Address("pune","MH");
		Employee emp1 = new Employee("Rajesh", "30", "9860279227", address);
		emp1.getAddress().setCity("NO");
		
		System.out.println(emp1);

	}

}
