package com.trycatch.example;

import java.io.IOException;

public class TryCatchExample {
	public static void main(String []args){
		
	}

	private static int getValOne() throws IOException{
		try{
			return 0;
		}catch(Exception ioE){
			
		}		
		finally{
			return 1;
		}
	}
}


