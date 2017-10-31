package multithreading;

import multithreading.model.BasicModel;

public class TransactionThread extends Thread {

	BasicModel model;

	public TransactionThread(BasicModel model, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.model = model;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			if (getName().equals("Deposit Thread"))
				model.update("Deposit", 2222);
			else
				model.update("Withdrawal", 4444);
		}
	}

}
