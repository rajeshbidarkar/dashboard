package com.string.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountWordsInString {

	public static void main(String[] args) {
		
		String string = "Hello my name Hello your name hello who you are you";
		
		String []str = string.split(" ");
		
		List<String> list = Arrays.asList(str);
		 
        /*Set<String> uniqueWords = new HashSet<String>(list);
        for (String word : uniqueWords) {
            System.out.println(word + ": " + Collections.frequency(list, word));
        }*/
		
		Map<String, Integer> wordCount = new HashMap<String, Integer>();

		for(String word: list) {
		  Integer count = wordCount.get(word);          
		  wordCount.put(word, (count==null) ? 1 : count+1);
		}
		
		System.out.println(wordCount.get("you"));
		
	}

}
