package com.immutable.example;

final public class Employee {
	
	private final String name;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", contact=" + contact + ", address=" + address + "]";
	}
	private final String age;
	private final String contact;
	private final Address address;
	public Employee(String name, String age, String contact, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.address = (Address) address.clone();
	}
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public String getContact() {
		return contact;
	}
	public Address getAddress() {
		return (Address) address.clone();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
}
