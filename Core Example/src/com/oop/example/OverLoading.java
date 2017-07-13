package com.oop.example;

public class OverLoading {
	
	/* Ambiguous for the type Over loading Example */
	
	public void OverLoading(){
		System.out.println("HELLo");
	}
	
	public void display(Integer intt){
		System.out.println(intt);
	}
	
	public void display(String str){
		System.out.println(str);
	}
	
	public void display(Object obj){
		System.out.println(" obj "+obj);
	}
	
	public static void main(String[] args) {
		
		new OverLoading().display(5.55);

	}

}
