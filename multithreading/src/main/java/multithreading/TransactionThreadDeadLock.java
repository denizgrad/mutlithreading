package multithreading;

import multithreading.model.BasicModel;

public class TransactionThreadDeadLock extends Thread {
	
	BasicModel model;
	private static String anotherSharedLock = "";
	  
	public TransactionThreadDeadLock(BasicModel model, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.model=model;
	}
	/**
	 * so it must get 2222 for deposit, 4444 for withdrawal
	 */
	public void run () {
		for (int i = 0; i < 100; i++){
			if(this.getName().equals("Deposit Thread")){
				synchronized (anotherSharedLock) {
					synchronized (model) { //sync
						model.str = "deposit";
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// nothing
						}
						model.number = 2222;
						System.out.println (model.str + " " + model.number + " " + i);
					}//sync
				}
			} else {
				synchronized (model) {
					synchronized (anotherSharedLock) { //sync
						model.str = "withdrawal";
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// nothing
						}
						model.number = 4444;
						System.out.println (model.str + " " + model.number + " " + i);
					}//sync
				}
			}
		}
		
	}
}
