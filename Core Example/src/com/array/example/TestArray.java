package com.array.example;

import java.util.HashMap;

public class TestArray {

	public static void main(String[] args) {
		
		int arr [] = {1,2,3,4,5};
		
		int len = arr.length;
		int j =0, temp;
		/*for(int i=len -1; i>=0;){			
			temp = arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i = i -2;
		}*/
		
		for(int i = 0; i < arr.length / 2; i++)
		{
		    temp = arr[i];
		    arr[i] = arr[arr.length - i - 1];
		    arr[arr.length - i - 1] = temp;
		}
		len = 0;
		while(len<arr.length){
			System.out.println(arr[len]);
			len++;
		}
	}
	HashMap map = new HashMap<>();

}
