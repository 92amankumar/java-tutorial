package com.concurrent.collections;

//Default Rentrant Lock
//16 buckets so seprate lock for each bucket
//16 concurrency level - 16 threads can enter at once
//load factor 0.75
//Read access concurrent i.e. not blocking
//Retrieval maynot fetch current/inprogress value
//Volatile Reads
//Null is not allowed in key
//Provide lot of atomic operations e.g. compute, So attempted operations on the map by other threads will be blocked till computation is in progress
//Better choice when more reads than writes

public class ConcurrentHashMapExample {
	public static void main(String[] args) {
	}
}
