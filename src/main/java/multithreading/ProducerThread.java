package multithreading;

import multithreading.model.SharedType;

public class ProducerThread extends Thread{
	 	private SharedType s;
	 	ProducerThread (SharedType s)
	   {
	      this.s = s;
	   }
	   public void run ()
	   {
	      for (char ch = 'A'; ch <= 'Z'; ch++)
	      {
	           try
	           {
	              Thread.sleep ((int) (Math.random () * 4000));
	           }
	           catch (InterruptedException e) {}
	           s.setC(ch);
	           System.out.println (ch + " produced by producer.");
	      }
	   }
}
