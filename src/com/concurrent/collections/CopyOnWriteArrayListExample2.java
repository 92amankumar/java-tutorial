package com.concurrent.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample2 {
	public static void main(String[] args) {
		String[] arr = { "A", "B", "C", "D", "E" };
		final List<String> list = new CopyOnWriteArrayList<>(Arrays.asList(arr));
		new Thread(() -> {
			Iterator<String> iterator = list.iterator();
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
			list.add("F");
		}).start();
		;
	}
}
