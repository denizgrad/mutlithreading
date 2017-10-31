package multithreading;

import multithreading.model.BasicModel;

public class TransactionThread2 extends Thread {
	
	BasicModel model;
	
	public TransactionThread2(BasicModel model, String name) {
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
				//sync crictical code
//				synchronized (model) { //sync
					model.str = "deposit";
					try {
						Thread.sleep((int) Math.random() * 1000);
					} catch (InterruptedException e) {
						// nothing
					}
					model.number = 2222;
					System.out.println (model.str + " " + model.number);
//				}//sync
				
			} else {
				//sync crictical code
//				synchronized (model) { //sync
					model.str = "withdrawal";
					try {
						Thread.sleep((int) Math.random() * 1000);
					} catch (InterruptedException e) {
						// nothing
					}
					model.number = 4444;
					System.out.println (model.str + " " + model.number);
//				}//sync
			}
		}
		
	}
}
