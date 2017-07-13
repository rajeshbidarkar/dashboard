package com.string.questions;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {

	public static void main(String[] args) {
		String s1="Hello World";
		System.out.println(reverseString(null));
		
		List list = new ArrayList<>();
		
		list.add(1);
	}
	public static String reverseString(String string){
		if(string!=null) {
			StringBuffer reverse=new StringBuffer();
			for(int i=string.length()-1;i>=0;i--)
			{
				reverse.append(string.charAt(i));
			}
			return (reverse.toString());
		}
		return "";	
	}
	
}
