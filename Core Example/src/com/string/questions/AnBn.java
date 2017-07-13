package com.string.questions;

public class AnBn {

	public static void main(String[] args) {
		String test = "aaaabbbbb";
		int aCnt =0, bCnt =0;
		for(int i=0;i<test.length();i++){
			if('a'==test.charAt(i)){
				aCnt ++ ;
			}
			if('b'==test.charAt(i)){
				bCnt ++ ;
			}
		}		
		System.out.println(aCnt + " "+bCnt);
	}
	
	
}
