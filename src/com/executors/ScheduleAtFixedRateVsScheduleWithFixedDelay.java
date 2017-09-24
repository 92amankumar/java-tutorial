package com.executors;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRateVsScheduleWithFixedDelay {
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		/*
		 * service.scheduleAtFixedRate(() -> { try { Thread.sleep(1000); } catch
		 * (Exception e) { e.printStackTrace(); }
		 * System.out.println("scheduleAtFixedRate:" + new Date()); }, 1, 3L,
		 * TimeUnit.SECONDS); service.shutdown();
		 */
		service.scheduleWithFixedDelay(() -> {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("scheduleWithFixedDelay:" + new Date());
		}, 1, 3L, TimeUnit.SECONDS);
	}
}

class TestCallable implements Callable<String> {
	@Override
	public String call() throws Exception {
		return null;
	}

}