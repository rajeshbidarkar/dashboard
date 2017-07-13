package com.concurrent.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentListExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> listL = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        
        // get the iterator
        Iterator<String> it = list.iterator();
        
        //manipulate list while iterating
        while(it.hasNext()){
            System.out.println("list is:"+list);
            it.remove();
            String str = it.next();
            System.out.println(str);
            if(str.equals("2"))list.remove("5");
            if(str.equals("3"))list.add("3 found");
            //below code don't throw ConcurrentModificationException
            //because it doesn't change modCount variable of list
            if(str.equals("4")) list.set(1, "4");
        }
        
        List<String> safeList = new CopyOnWriteArrayList<>();
        safeList.add("1");
        safeList.add("2");
        safeList.add("3");
        safeList.add("4");
        safeList.add("5");
        
        // get the iterator
        Iterator<String> itSafe = safeList.iterator();
        
        //manipulate list while iterating
        while(itSafe.hasNext()){
        	itSafe.remove();
            System.out.println("list is:"+list);
            String str = itSafe.next();
            System.out.println(str);
            safeList.remove("5");
           	safeList.add("3 found");
            //below code don't throw ConcurrentModificationException
            //because it doesn't change modCount variable of list
           // if(str.equals("4")) safeList.set(1, "4");
        }
        System.out.println(safeList);
    }

}
