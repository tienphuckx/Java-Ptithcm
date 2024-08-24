package com.phuccode.hashmap;

import java.util.HashMap;

public class PhucHashMap {
	public static void main(String[] args) {
		// HOAT DONG THEO CO CHE KEY ==> CMND
		HashMap<Integer, String> ds = new HashMap<Integer, String>();
		ds.put(113, "SDT cong an");
		ds.put(114, "SDT Linh cuu hoa");
		ds.put(115, "SDT cap cuu");
		
		String info = ds.get(113);
		System.out.println(info);
		
		// DUYET
		for(String nv: ds.values())
		{
			System.out.println(nv);
		}
		
		// XOA
		ds.remove(113);
		
		// DUYET
				for(String nv: ds.values())
				{
					System.out.println(nv);
				}
	}
}
