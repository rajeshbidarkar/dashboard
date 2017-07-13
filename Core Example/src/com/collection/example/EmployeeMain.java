package com.collection.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee("100","ABC");
		Employee emp2 = new Employee("10","ABC");
		Employee emp3 = new Employee("90","ABC");
		Employee emp4 = new Employee("1","ABC");
		Employee emp5 = new Employee("5","ABC");
		
		HashMap<Employee, String> map = new HashMap<Employee, String>();
		map.put(emp1, "100");
		map.put(emp2, "10");
		map.put(emp3, "90");
		map.put(emp4, "1");
		map.put(emp5, "5");
		
		Set<Entry<Employee, String>> empSet = map.entrySet();
		List<Entry<Employee, String>> list = new ArrayList<Map.Entry<Employee, String>>(empSet);
		for(Map.Entry<Employee, String> lt : list){
			System.out.println(lt.getKey().getEmpId());
		}
		Collections.sort(list, new Comparator<Map.Entry<Employee, String>>() {
			@Override
			public int compare(Map.Entry<Employee, String> o1, Map.Entry<Employee, String> o2) {
				// TODO Auto-generated method stub
				return o2.getKey().getEmpId().compareTo(o1.getKey().getEmpId());
			}
		});
		for(Map.Entry<Employee, String> lt : list){
			System.out.println(lt.getKey().getEmpId());
		}
	}

}
