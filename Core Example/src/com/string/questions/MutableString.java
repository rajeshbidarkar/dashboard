package com.string.questions;

public class MutableString implements CharSequence {
	private char[] array;   
    private int size = 0;   
   
    public MutableString()
    {
        this(10);
    }
 
    public MutableString(int capacity)
    {
        array = new char[capacity];
    }
 
    public MutableString(CharSequence s)
    {
        array = new char[s.length()];
        add(s);
    }
 
    public void add(CharSequence s)   
    {   
    	ensureSize(size + s.length());   
        for (int i = 0; i < s.length(); i++)   
        {  
        	System.out.println(array.length);
            array[size++] = s.charAt(i);   
        }   
    }   
 
    private void ensureSize(int size)   
    {   
    	if (size > array.length)   
        {   
            char[] array = new char[size]; // naive approach           
            System.arraycopy(this.array, 0, array, 0, this.size);   
        }   
    }
 
    public int length()
    {
        return size;
    }
 
    public char charAt(int index)
    {
        if (index >= size) throw new IndexOutOfBoundsException();
        return array[index];
    }
 
    public CharSequence subSequence(int start, int end)
    {
        // TODO: range check
        MutableString sub = new MutableString(end - start);
        for (int i = start; i <= end; i++)
        {
            sub.array[i - start] = array[i];
        }
        return (CharSequence) sub;
    }
 
    public String toString()
    {        
        return new String(array, 0, size);
    }
    public static void main(String[] args) {
    	MutableString mt = new MutableString("Test");
    	mt.add("Pa");
    	
    	System.out.println("  @@@@@ "+mt);
    	
    }
}
