package multithreading;

public class InterruptedThread extends Thread {
	public InterruptedThread(String name) {
		super(name);
	}

	int count = 0;

	public void run() {
		while (!isInterrupted()) {
			try {
				Thread.sleep((int) (Math.random() * 10));
			} catch (InterruptedException e) {
				System.out.println(getName() + " about to terminate...");
				// Because the Boolean flag in the consumer thread's thread
				// object is clear, we call interrupt() to set that flag.
				// As a result, the next consumer thread call to isInterrupted()
				// retrieves a true value, which causes the while loop statement
				// to terminate.
				interrupt();
				System.out.println(getName() + " terminated");
			}
			System.out.println(getName() + " " + count++);
		}
		System.out.println(getName() + " run continues");
	}
}
