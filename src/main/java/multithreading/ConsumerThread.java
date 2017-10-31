package multithreading;

import multithreading.model.SharedType;

public class ConsumerThread extends Thread{
	private SharedType s;
	   public ConsumerThread(SharedType s)
	   {
	      this.s = s;
	   }
	   public void run ()
	   {
	      char ch;
	      do
	      {
	         try
	         {
	            Thread.sleep ((int) (Math.random () * 4000));
	         }
	         catch (InterruptedException e) {}
	         ch = s.getC();
	         System.out.println (ch + " consumed by consumer.");
	      }
	      while (ch != 'Z');
	   }
}
