package com.phuccode.hashmap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PhucHashSet {

	public static void main(String[] args) 
	{
		 HashSet<String> setA = new HashSet<String>();
		        setA.add("Java");
		        setA.add("Python");
		        setA.add("Java");
		        setA.add("PHP");
		        System.out.println("Số phần tử của setA: " + setA.size());
		        System.out.println("Các phần tử của setA: " + setA);
		        System.out.println("setA có chứa Java không? " + setA.contains("Java"));
		        System.out.println("setA có chứa C++ không? " + setA.contains("C++"));
		    
		 for (String element : setA) 
		 {
		     System.out.println(element);
		 }
		 
		 
		 setA.remove("PHP");
		 setA.clear();
		 setA.size();
		 setA.isEmpty(); // kiem tra rong ?
		 
		 
		 List<String> listA = new ArrayList<String>();
		        // chuyển đổi setA thành listA
		 listA.addAll(setA);

		}
	}


