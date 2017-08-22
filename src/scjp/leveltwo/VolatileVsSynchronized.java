package scjp.leveltwo;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileVsSynchronized {
	public int commInt = 0;
	
	public volatile int volaInt = 0;
	
	public static int staticInt = 0;
	
	public volatile AtomicInteger ai = new AtomicInteger();
	
	public static void main(String[] args) {
		VolatileVsSynchronized lock = new VolatileVsSynchronized();
		for (int i = 0; i < 5000; i++) {
			MyThread1 t = new MyThread1();
			t.setName("T" + i);
			t.setLock(lock);
			t.start();
		}
	}

}

class MyThread1 extends Thread {
	public static volatile int count = 0;
	private VolatileVsSynchronized lock = null;
	
	public void setLock(VolatileVsSynchronized lock){
		this.lock = lock;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		} catch (NullPointerException e) { //Correct, even it is a RuntimeException
			System.out.println("Catch NullPointer:" + e.toString());
		}
		
		//synchronized, 5000 
		synchronized(lock){
			lock.commInt++;
			//System.out.println(lock.commInt);
		}
		
		//non-synchronized - Ideally, 5000 would be printed, but NOT !!!
		//lock.commInt++;
		//System.out.println(lock.commInt);
		
		//non-synchronized - Ideally, 5000 would be printed, but NOT !!!
		lock.volaInt++;
		//System.out.println(lock.volaInt);
		
		//non-synchronized - Ideally, 5000 would be printed, but NOT !!!
		lock.staticInt++;
		//System.out.println(lock.staticInt);
		
		//Even NOT print 5000 lines
		//int myAi = lock.ai.incrementAndGet();
		//System.out.println("AtomicInteger - " + myAi);
	}

}
