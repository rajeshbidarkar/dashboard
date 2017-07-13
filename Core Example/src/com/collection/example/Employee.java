package com.collection.example;

/**
*
* We must implement Comparable interface and override compareTo method
*/
public class Employee implements Comparable<Employee>{

public Employee() {

}

public Employee(String empId, String empName) {
this.empName = empName;
this.empId = empId;
}

private String empId;
public String getEmpId() {
	return empId;
}

public void setEmpId(String empId) {
	this.empId = empId;
}

private String empName;

public String getEmpName() {
return empName;
}
public void setEmpName(String empName) {
this.empName = empName;
}

/**
* compareTo method is used while sorting an employee
*/
public int compareTo(Employee o) {
/**
* we compare two names of the employee to figure out,
* two employees are equal or not
*/
return this.empName.compareTo(o.getEmpName());
}
}
