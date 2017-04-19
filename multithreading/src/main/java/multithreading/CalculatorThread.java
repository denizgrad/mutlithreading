package multithreading;

import java.util.Date;

public class CalculatorThread extends Thread {

	boolean negative = true;
	double pi;
	
	public CalculatorThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public void run() {
		 for (int j = 0; j < 5; j++){
		
//			 System.out.println("Started calculating PI : " + pi  + " " + MAIN.sdf.format(new Date()));
				for (int i = 3; i < 100000; i += 2) {
					if (negative)
						pi -= (1.0 / i);
					else
						pi += (1.0 / i);
					negative = !negative;
				}
				pi += 1.0;
				pi *= 4.0;
				System.out.println(getName() + ": Finished calculating PI :" + pi  + " " +    MAIN.sdf.format(new Date()));
		 }
	}
}
