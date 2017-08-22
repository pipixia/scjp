package scjp.leveltwo;

public class ThreadWaitNotify {
	public static void main(String[] args) {
		Message msg = new Message(">>> Initial Message");
		Waiter waiter = new Waiter(msg);
		new Thread(waiter, "waiter-1").start();

		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter1, "waiter-2").start();

		Notifier notifier = new Notifier(msg);
		new Thread(notifier, "notifier").start();
		System.out.println("All the threads are started");
	}
}

class Message {
	private String msg;

	public Message(String str) {
		this.msg = str;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String str) {
		this.msg = str;
	}

}

class Waiter implements Runnable {

	private Message msg;

	public Waiter(Message m) {
		this.msg = m;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			try {
				System.out.println(name + " waiting to get notified, time:" + System.currentTimeMillis());
				msg.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " has got notified at time:" + System.currentTimeMillis());
			// process the message now
			System.out.println("************* " + name + " processed message: " + msg.getMsg());
		}
	}

}

class Notifier implements Runnable {

	private Message msg;

	public Notifier(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " thread started");
		try {
			Thread.sleep(1000);
			synchronized (msg) {
				msg.setMsg(name + " notify waiters");
				msg.notify(); //Only notify one pending thread
				//msg.notify();
				//msg.notifyAll(); //Notify all threads
				
				/*
				 * Wait, notify and notifyAll are method in Object. They need to be called from synchronized method or block
				 * Sleep is method in Thread, and it is static, sleep is not giving out resource lock
				 */
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
