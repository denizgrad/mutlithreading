package multithreading.model;

public class SharedType {

	private char c= '\u0000';
	private boolean consumable  = false;
	
	//object lock olmadan
//	public char getC() {
//		return c;
//	}
//
//	public void setC(char c) {
//		this.c = c;
//	}
	///
	//object lock varken
	public synchronized void setC (char c)
	   {
	      while (consumable){
	         try
	         {
	            wait ();
	         }
	         catch (InterruptedException e) {}
	      }
	      this.c = c;
	      consumable = true;
	      notify ();
	   }

	public synchronized char getC ()
	   {
	      while (!consumable){
	         try
	         {
	            wait ();
	         }
	         catch (InterruptedException e) { }
	      }
	      consumable = false;
	      notify ();

	      return c;
	   }
	
}
