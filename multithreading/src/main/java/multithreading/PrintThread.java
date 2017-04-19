package multithreading;

public class PrintThread extends Thread
{
	
	public PrintThread(String name){
		super(name);
	}
	public PrintThread(){
		super();
	}
	
    public void run ()
    {
        System.out.println("::: " + this.getName() + " 's run method");
       for (int count = 1, row = 1; row < 20; row++, count++)
       {
    	   System.out.print(getName()+" ");
            for (int i = 0; i < count; i++)
                 System.out.print ('ß');
            System.out.print ('\n');
       }
    }
 }

