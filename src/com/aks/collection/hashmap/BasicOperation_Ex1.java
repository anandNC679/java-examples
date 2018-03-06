package com.aks.collection.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BasicOperation_Ex1 {

	public static void main(String[] args) {
		BasicOperation_Ex1 basicOperation_Ex1 = new BasicOperation_Ex1();
		HashMap<String,Integer> map = new HashMap<>();
		//System.out.println(basicOperation_Ex1.printMap(map));
		basicOperation_Ex1.printMap(map);
		map.put("anand", 1060);
		map.put("waseem",2340);
		map.put("vaheed",3060);
		map.put("karan", 1050);
		map.put("manu",2300);
		map.put("rajan",4100);
		
		basicOperation_Ex1.printMap(map);
		
		if(map.containsKey("anand")) {
			System.out.println("anand has value = "+map.get("anand"));
		}
		System.out.println("\nItarate the map on the basis of key:-");
		Iterator<String> keySetIterator = map.keySet().iterator();
		while(keySetIterator.hasNext()) {
			String key = keySetIterator.next();
			System.out.println(key +" has rs "+map.get(key));
		}
		System.out.println("\n\nsorting the map on the basis of key:-");
		TreeMap<String, Integer> sortedMap=new TreeMap<>(map);
		basicOperation_Ex1.printMap(sortedMap);
		
		System.out.println("\n\n******************************\nclearing the hashmap:-");
		map.clear();
		basicOperation_Ex1.printMap(map);
	}

	private void printMap(TreeMap<String, Integer> sortedMap) {
		//System.out.println(sortedMap);
		Iterator<String> iterator=sortedMap.keySet().iterator();
		while(iterator.hasNext()) 
		{
			String key=iterator.next();
			System.out.println("key="+key+" and value="+sortedMap.get(key));
		}
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
