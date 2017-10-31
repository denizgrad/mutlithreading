package multithreading;

public class InterruptorThread extends Thread{

	private Thread interruptedTread;
	
	public Thread getInterruptedTread() {
		return interruptedTread;
	}
	public void setInterruptedTread(Thread interruptedTread) {
		this.interruptedTread = interruptedTread;
	}

	InterruptorThread (String name, Thread thread){
		super();
		this.setName(name);
		this.setInterruptedTread(thread);
	}
	
	public void run ()
	   {
	      int sleepTime = (int) (Math.random () * 100);
	      System.out.println (getName () + " sleeping for " + sleepTime +
	                          " milliseconds.");
	      try
	      {
	         Thread.sleep (sleepTime);
	      }
	      catch (InterruptedException e)
	      {
	      }
	      System.out.println (getName () + " waking up, interrupting other " +
	                          "thread and terminating.");
	      interruptedTread.interrupt ();
	   }
}
