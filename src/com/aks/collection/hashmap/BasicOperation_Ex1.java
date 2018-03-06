package com.aks.collection.hashmap;

import java.util.HashMap;

public class BasicOperation_Ex1 {

	public static void main(String[] args) {
		BasicOperation_Ex1 basicOperation_Ex1 = new BasicOperation_Ex1();
		HashMap<String,Integer> map = new HashMap<>();
		basicOperation_Ex1.printMap(map);
		map.put("anand", 1000);
		map.put("waseem",2000);
		map.put("vaheed",3000);
		basicOperation_Ex1.printMap(map);
		
		if(map.containsKey("anand")) {
			System.out.println("anand has value = "+map.get("anand"));
		}
		
		map.clear();
		basicOperation_Ex1.printMap(map);
		
	}

	private void printMap(HashMap<String, Integer> map) {
		if(map.isEmpty()) {
			System.out.println("HashMap is empty");
		}
		else {
			System.out.println(map);
		}
	}

	

}
