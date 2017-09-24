package com.concurrent.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

//Backed by CopyOnWriteArrayList
public class CopyOnWriteArraySetExample {
	public static void main(String[] args) {
		String[] arr = { "A", "B", "C", "D", "E" };
		final Set<String> set = new CopyOnWriteArraySet<>(Arrays.asList(arr));
		new Thread(() -> {
			Iterator<String> iterator = set.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			set.add("F");
		}).start();
		;
	}
}
