package com.aks.collection.hashmap;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class MapSortingExample {

  
    public static void main(String args[]) {
  
        Map<String, Integer> olympicMap = new HashMap<String, Integer>();
      
        olympicMap.put("England", 3);
        olympicMap.put("USA", 1);
        olympicMap.put("China", 2);
        olympicMap.put("Russia", 4);
        olympicMap.put("India", 5);
        olympicMap.put("Australia", 4); //adding duplicate value
      
        System.out.println("Unsorted Map in Java :- " + olympicMap);
      
        //sorting Map e.g. HashMap, Hashtable by keys in Java
        Map<String, Integer> sorted = sortByKeys(olympicMap);
        System.out.println("Sorted Map in Java by key:- " + sorted);
      
      
        //sorting Map like Hashtable and HashMap by values in Java
        sorted = sortByValues(olympicMap);
        System.out.println("Sorted Map in Java by values:- " + sorted);
      
      
        //Sorting Map in Java by keys using TreeMap
        Map<String, Integer> sortedMapByKeys = new TreeMap<String,Integer>();
        sortedMapByKeys.putAll(olympicMap);
        System.out.println("Sorted Map in Java by key using TreeMap :- " + sortedMapByKeys);
 
      
    }
  
    /*
     * Paramterized method to sort Map e.g. HashMap or Hashtable in Java
     * throw NullPointerException if Map contains null key
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static <K extends Comparable,V extends Comparable> Map<K,V> sortByKeys(Map<K,V> map){
        List<K> keys = new LinkedList<K>(map.keySet());
        Collections.sort(keys);
      
        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
        for(K key: keys){
            sortedMap.put(key, map.get(key));
        }
      
        return sortedMap;
    }
  
    /*
     * Java method to sort Map in Java by value e.g. HashMap or Hashtable
     * throw NullPointerException if Map contains null values
     * It also sort values even if they are duplicates
     */
    @SuppressWarnings({"rawtypes","unchecked"})
	public static <K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map){
        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
      
        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {
        	@Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
      
        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
      
        for(Map.Entry<K,V> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
      
        return sortedMap;
    }

}

