package com.array.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ReverseArray {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6};
		 arr = rvereseArray(arr, 0, arr.length-1);
		 int i;
		 for (i=0; i < arr.length; i++)
		   System.out.print(" "+arr[i]);
		 String strArr[] = {"R", "A", "J", "E", "S", "H"};
		 strArr = rvereseArrayOfString(strArr, 0, strArr.length-1);
		 for (i=0; i < strArr.length; i++)
			   System.out.println(" "+strArr[i]);
		 
		 
		 ArrayList<Integer> d = new ArrayList<Integer>();
		 d.add(2);
		 d.add(4);
		 d.add(5);
		 d.add(7);
		 d.add(8);
		 d.add(9);

		 ArrayList<Integer> e = new ArrayList<Integer>();
		 e.add(3);
		 e.add(10);
		 
		 Set set = new HashSet<Integer>();
		 
		 set.addAll(e);
		 set.addAll(d);
		 
		 
		 System.out.println(set);
		 
		 System.out.println(set.add(99));
		 
	}
	
	static int[] rvereseArray(int arr[], int start, int end)
	{
	    int temp;
	    while (start < end)
	    {
	        temp = arr[start];   
	        arr[start] = arr[end];
	        arr[end] = temp;
	        start++;
	        end--;
	    } 
	    return arr;
	}
	
	static String[] rvereseArrayOfString(String arr[], int start, int end)
	{
	    String temp;
	    while (start < end)
	    {
	        temp = arr[start];   
	        arr[start] = arr[end];
	        arr[end] = temp;
	        start++;
	        end--;
	    } 
	    return arr;
	}
}
