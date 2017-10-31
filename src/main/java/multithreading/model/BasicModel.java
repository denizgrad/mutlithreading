package multithreading.model;

public class BasicModel {
	 public static String str;
	 public static double number;
	 
	 public synchronized void update (String str, double number)
	   {
	      this.str = str;
	      this.number = number;
	      System.out.println (this.str + " " + this.number);
	   }
}
