package com.array.example;

public class ThirdLargest {
		public static void main(String args[]){
			int arr[] = {67, 56, 87, 42};
			
		    for (int i = 0; i <arr.length - 1; i++) {
		        if (arr[i] < arr[i + 1]) {
		            int swap = arr[i];
		            arr[i] = arr[i + 1];
		            arr[i + 1] = swap;       
		        }
		    }

		    System.out.println("third highest element is: " + arr[2]);
		
		    int[] fred = {0, 5, 7, 3, 20, 3, 44};
		    int max = 1;
		    for(int i = 0; i < fred.length; i++){
		    if(i == 0)
		    max = i;
		    else{
		    if(fred[i] > max)
		    max = fred[i]; 
		    }
		    }
		    System.out.println(max);
		      
		    }
		
		  
		
}
