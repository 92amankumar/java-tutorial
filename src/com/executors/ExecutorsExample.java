package com.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Executor Interface --> 1) ExecutorService 2)ScheduledExecutorService
//newCachedThreadPool() - Creates a thread pool that creates new threads as needed, 
//but will reuse previously constructed threads when they are available
//newFixedThreadPool(int numThreads) - Creates a thread pool that reuses a fixed number of threads
//newScheduledThreadPool(int numThreads) - Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically
//newSingleThreadExecutor() - Creates an Executor that uses a single worker thread operating off an unbounded queue
public class ExecutorsExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Runnable runnable = () -> {
//			System.out.println("Hello");
		};

		ExecutorService service = Executors.newFixedThreadPool(5);
		List<Future<?>> futures = new ArrayList<>(5);
		for (int i = 0; i < 5; i++) {
			futures.add(service.submit(runnable));
		}
		int i = 0;
		do {
			if (futures.get(i).isDone()) {
				System.out.println(futures.get(i).get());
				futures.remove(i);
			}
			i++;
			if (i >= futures.size()) {
				i = 0;
			}
		} while (futures.size() > 0);
		service.shutdown();
	}
}
