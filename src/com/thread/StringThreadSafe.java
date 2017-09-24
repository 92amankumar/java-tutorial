package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StringThreadSafe {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String testString = "TEST";
		System.out.println("Goin to check string");
		checkThreadSafetyStringAndBuffer(testString);
		System.out.println(testString);

		System.out.println("Goin to check stringBuffer");
		StringBuffer testStringBuffer = new StringBuffer(testString);
		checkThreadSafetyStringAndBuffer(testStringBuffer);
		System.out.println(testStringBuffer);
		
		System.out.println("Goin to check stringBuilder");
		StringBuilder testStringBuilder = new StringBuilder(testString);
		checkThreadSafetyStringAndBuffer(testStringBuilder);
		System.out.println(testStringBuilder);

	}
	
	static void checkThreadSafetyStringAndBuffer(CharSequence charseq) throws InterruptedException, ExecutionException{
		ExecutorService service = Executors.newFixedThreadPool(5);
		List<Future<CharSequence>> futures = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			futures.add(service.submit(new StrThread(charseq)));
		}
		if(futures.size()>0){
			while(futures.size()>0){
				Future<CharSequence> future = futures.get(futures.size()-1);
				if(future.isDone()){
					System.out.println(future.get().toString());
					futures.remove(future);
				}
			}
		}
		service.shutdown();
		System.out.println("complete");
	}
}

class StrThread implements Callable<CharSequence> {
	private CharSequence str;
	
	public StrThread(CharSequence str) {
		this.str = str;
	}

	@Override
	public CharSequence call() throws Exception {
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(str instanceof String)
			str = str + Thread.currentThread().getName();
		else if(str instanceof StringBuffer)
			((StringBuffer) str).append(Thread.currentThread().getName());
		else if(str instanceof StringBuilder)
			((StringBuilder) str).append(Thread.currentThread().getName());
		return str;
	}
}