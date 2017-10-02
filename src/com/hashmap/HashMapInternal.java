package com.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapInternal {
	private static final Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Map<Integer, Integer> localMap = map;
		localMap.put(1, 2);
		localMap.put(2, 2);
		System.out.println(localMap);
		System.out.println(map);
	}
}
