package com.aks.collection.json;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONValue;

public class Map2jsonObject {

	public static void main(String[] args) {
		Map<String,Integer> map=new TreeMap<>();
		map.put("A", 1000);
		map.put("B", 1600);
		map.put("C", 1900);
		map.put("AD", 5000);
		map.put("E", 3000);
		map.put("W", 2000);
		
		System.out.println(map);
		String jsonObject=JSONValue.toJSONString(map);
		System.out.println(jsonObject);
	}

}
