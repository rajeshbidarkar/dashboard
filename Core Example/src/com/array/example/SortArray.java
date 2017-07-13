package com.array.example;

public class SortArray {

	public static void main(String[] args) {
		int arr[] = {67, 56, 87, 42};
		arr = sortArray(arr);
		for (int i = 0; i < arr.length; i++)
		{
		         System.out.println(arr[i]);
		}
		double[][] A = new double[2][2];
        A[0][0] = 1.5;
        A[0][1] = -2.0;
        A[1][0] = 7.3;
        A[1][1] = -13.5;
        System.out.println(transposeMatrix(A));
		
	}
	public static int[] sortArray(int arr[]) {	
		 for (int i = 0; i < arr.length; i++) {
		        for (int j = i + 1; j < arr.length; j++) {
		            int tmp = 0;
		            if (arr[i] > arr[j]) {
		                tmp = arr[i];
		                arr[i] = arr[j];
		                arr[j] = tmp;
		            }
		        }
		    }
        return arr;
	}
	public static double[][] transposeMatrix(double [][] m){
        double[][] temp = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }
	
}
