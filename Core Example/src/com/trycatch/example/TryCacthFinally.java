package com.trycatch.example;
import java.util.HashMap;
import java.util.Map;

public class TryCacthFinally {
	
	
	public static void main(String []args){
		System.out.println("HIIIIIIIIIIII"+returnVal());
		
		String s1 = "Sachin";
		String s2 = "Sachin";
		String s3 = "Sachin";
		
		Map<String , String> map = new HashMap<String, String>();
		
		
		map.put(s1, "Tendulkar");
		
		map.put(s2, "Tendulkar2");
		
		map.put(s3, "Tendulkar3");
		
		
		System.out.println(" GET Value ::::"+map.get(s1));
		
	}
	public static int returnVal(){
		try{
			throw new Exception();
		}catch(Exception exp){
			throw new Exception();			
		}finally{
			return 3;
		}
	}
}
