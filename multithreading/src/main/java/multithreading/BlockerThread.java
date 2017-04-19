package multithreading;

public class BlockerThread extends Thread
{
	   private boolean finished = false;
	   public void run ()
	   {
	      while (!finished)
	      {
	         try
	         {
	            int i;
	            do {
	               System.out.println ("enter smth, sytem read blocked");
	               i = System.in.read (); //reads keyboard input. if none, keeps blocking
	               System.out.println (i + " is entered ");
	            }
	            while (i != '\n');
	            System.out.println ("asdasd");
	         }
	         catch (java.io.IOException e)
	         {
	         }
	      }
	      System.out.println ("blocker finished");
	   }
	   public void setFinished (boolean f)
	   {
	      finished = f;
	   }
	}