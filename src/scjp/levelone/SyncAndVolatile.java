package scjp.levelone;

public class SyncAndVolatile {
	public static void main(String[] args) throws Exception {

		JoinThread threads[] = new JoinThread[100];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new JoinThread();
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {

			threads[i].join();
		}
		System.out.println(" n= " + threads[99].n);
	}
}

class JoinThread extends Thread {
	public volatile static int n = 0; 

	public static synchronized void inc() {
		n++;
	}

	public void run() {
		for (int i = 0; i < 10; i++)
			try {
				 
				//inc();//Synchronized method, guarantee n=1000; 
				n++;//N could be dynamic 9xx; n is volatile
				sleep(30);

			} catch (Exception e) {
			}
	}

}
