package multithreading;

public class RunningThread extends Thread {
	private boolean finished = false;

	public void run() {
		int sum = 0;
		System.out.println("run starts");
		while (!finished){
			sum++;
			if (sum % 1000000000 == 0){
				System.out.println("RunningThread still running");
			}
		}
		System.out.println("sum: "+sum);
		System.out.println("run ends");
	}

	public void setFinished(boolean f) {
		finished = f;
	}
}