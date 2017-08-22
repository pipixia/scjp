package scjp.leveltwo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueExample {

	public static void main(String[] args) {

		/*
		 *  - Natural ordering example of priority queue
		 *	- PriorityQueue **doesn’t allow null** values
		 *  - NOT thread-safe, provided O(log(n)* time for enqueing(Add) and dequeing(Poll) operations
		 */
		
		Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {
			int myInt = rand.nextInt(100);
			System.out.println("Add Integer - " + myInt);
			integerPriorityQueue.add(new Integer(myInt));
		}

		for (int i = 0; i < 7; i++) {
			Integer in = integerPriorityQueue.poll(); //Poll - Retrieves and removes the head of this queue, or returns null if this queue is empty.
			System.out.println("Processing Integer:" + in);
		}

		// PriorityQueue example with Comparator
		Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
		/*
		 * if no comparator provided or customer not implementing Comparable, 
		 * will throw exception - Customer cannot be cast to java.lang.Comparable  
		 * 
		 * Comparator higher then Comparable defined in Customer
		 */
		addDataToQueue(customerPriorityQueue);		
		pollDataFromQueue(customerPriorityQueue);

	}

	// Comparator anonymous class implementation
	public static Comparator<Customer> idComparator = new Comparator<Customer>() {

		@Override
		public int compare(Customer c1, Customer c2) {
			return (int) (c1.getId() - c2.getId()); 
		}
	};

	// utility method to add random data to Queue
	private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {
			int myId = rand.nextInt(100);
			System.out.println("Add Customer - " + myId);
			customerPriorityQueue.add(new Customer(myId, "Customer-" + myId));
		}
	}

	// utility method to poll data from queue
	private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
		while (true) {
			Customer cust = customerPriorityQueue.poll();
			if (cust == null)
				break;
			System.out.println("Processing Customer with ID=" + cust.getId());
		}
	}
}

class Customer implements Comparable<Customer>{
	
	private int id;
	private String name;
	
	public Customer(int i, String n){
		this.id=i;
		this.name=n;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Customer o) {
		if(o == null){
			return -1;
		}
		
		return o.id - this.id; //Descent order - like 3,2,1
	}
	
}
