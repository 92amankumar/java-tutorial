package com.thread;

/*volatile just guarantees visibility, atomicity is not guaranteed by the volatile.

volatile variables reduces the risk of memory consistency errors, because any write to a volatile variable establishes a happens-before relationship with subsequent reads of that same variable.

 * On executing this code you may get the first thread printing “printing value 1” to “printing value 5000”
 *  but after that second thread won’t start and the program will never terminate.
 *  Because the second thread never gets the updated value of flag and code execution goes into a deadlock.
 *  In this case having the boolean variable flag as volatile will help. That will guarantee that the change
 *  done to the shared variable by one thread is visible to other threads.
 * */
public class VolatileDemo {
	private static boolean flag = false;

	public static void main(String[] args) {

		Thread done = new Thread(() -> {
			int i = 0;
			while (!flag)
				i++;
			System.out.println("Job Done" + i);
		});
		System.out.println(done+"-->"+done.getState());
		done.start();
		new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				System.out.println("Printing " + i);
			}
			flag = true;
			System.out.println(done+"-->"+done.getState());
		}).start();

	}
}
