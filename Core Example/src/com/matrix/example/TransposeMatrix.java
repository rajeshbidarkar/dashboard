package com.matrix.example;

public class TransposeMatrix {

	public static void main(String[] args) {
		
		int[][] a = { { 5, 1, 1 }, { 3, 6, 0 }, { 0, 5, 9 } };
		int[][] c = { { 5, 1, 1 }, { 3, 6, 0 }, { 0, 5, 9 } };
		int n = a.length;
		 int row = a.length;
		 int colm = a[0].length;
		 System.out.println(row +" "+colm);
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }
		
		int[][] b = trasposeMatrix(a);
		
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.printf("%4d", b[i][j]);
            }
            System.out.println();
        }
		
		b = additionMatrix(a,c);
		
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", b[i][j]);
            }
            System.out.println();
        }
		
		
	}
	public static int[][] trasposeMatrix(int[][] matrix) {
	    int row = matrix.length;
	    int colm = matrix[0].length;
	    int[][] trasposedMatrix = new int[colm][row];
	    for(int x = 0; x < colm; x++) {
	        for(int y = 0; y < row; y++) {
	            trasposedMatrix[x][y] = matrix[y][x];
	        }
	    }
	    return trasposedMatrix;
	}
	
	public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
	    int row = matrix1.length;
	    int colm = matrix1[0].length;
	    int[][] additionMatrix = new int[colm][row];
	    for(int x = 0; x < colm; x++) {
	        for(int y = 0; y < row; y++) {
	        	additionMatrix[x][y] = matrix1[x][y] + matrix2[x][y];
	        }
	    }
	    return additionMatrix;
	}
	
	
}
