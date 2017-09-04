package com.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapPutCustomObject {
	public static void main(String[] args) {
		CustomPOJO pojo1 = new CustomPOJO(10,"ABC");
		System.out.println(pojo1.hashCode());
		CustomPOJO pojo2 = new CustomPOJO(10,"ABC");
		System.out.println(pojo2.hashCode());
		Map<CustomPOJO,Integer> map = new HashMap<>();
		map.put(pojo1, 10);
		map.put(pojo2, 20);
		System.out.println(map.size());
		System.out.println(map.get(new CustomPOJO(10, "ABC")));
	}
}

class CustomPOJO {
	private long id;
	private String name;
	
	public CustomPOJO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}