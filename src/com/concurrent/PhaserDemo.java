package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserDemo {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(1);
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			service.submit(new PhaserFileDemo("File-"+(i+1), phaser));
		}
		int currPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currPhase + " completed");
        service.shutdown();
	}
}

class PhaserFileDemo implements Runnable{
	private String filename;
	private Phaser phaser;
	
	public PhaserFileDemo(String filename, Phaser phaser) {
		super();
		this.filename = filename;
		this.phaser = phaser;
	}

	@Override
	public void run() {
        System.out.println("This is phase " + phaser.getPhase());
		System.out.println(Thread.currentThread().getName()+" Reading "+filename+" parsing and storing in DB");
		phaser.arriveAndAwaitAdvance();
		System.out.println("Deresigtering");
		phaser.arriveAndDeregister();
	}
	
}


class PhaserQueryDemo implements Runnable{
	private String query;
	private Phaser phaser;
	
	public PhaserQueryDemo(String query, Phaser phaser) {
		super();
		this.query = query;
		this.phaser = phaser;
	}

	@Override
	public void run() {
		
	}
	
}