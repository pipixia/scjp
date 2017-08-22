package scjp.leveltwo;

public class ThreadDeadlock {

    public static void main(String[] args) throws InterruptedException {
    	ResourceLock obj1 = new ResourceLock();
    	ResourceLock obj2 = new ResourceLock();
    	ResourceLock obj3 = new ResourceLock();
    	
    	obj1.setResourceName("ResourceLock [ *1 ]");
    	obj2.setResourceName("ResourceLock [ $2 ]");
    	obj3.setResourceName("ResourceLock [ @3 ]");
    
        Thread t1 = new Thread(new SyncThread(obj1, obj2), "*** T1 *** ");
        Thread t2 = new Thread(new SyncThread(obj2, obj3), "$$$ T2 $$$ ");
        Thread t3 = new Thread(new SyncThread(obj3, obj1), "@@@ t3 @@@ ");
        
        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();
        
    }

}

class SyncThread implements Runnable{
    private ResourceLock obj1;
    private ResourceLock obj2;

    public SyncThread(ResourceLock o1, ResourceLock o2){
        this.obj1=o1;
        this.obj2=o2;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on "+obj1.getResourceName());
        synchronized (obj1) {
         System.out.println(name + " got lock on "+obj1.getResourceName());
         work();
         System.out.println(name + " acquiring lock on "+obj2.getResourceName());
         synchronized (obj2) {
            System.out.println(name + " got lock on "+obj2.getResourceName());
            work();
        }
         System.out.println(name + " released lock on "+obj2.getResourceName());
        }
        System.out.println(name + " released lock on "+obj1.getResourceName());
        System.out.println(name + " finished execution.");
    }
    
    private void work() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ResourceLock{
	private String ResourceName;

	public String getResourceName() {
		return ResourceName;
	}

	public void setResourceName(String resourceName) {
		ResourceName = resourceName;
	}
}
