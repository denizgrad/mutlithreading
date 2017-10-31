package multithreading;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author deniz.ozen
 */
public class MAIN {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	/**1
	 * @param args
	 * to see the threads not in an ordered execution 
	 */
//	public static void main (String [] args)
//	   {
////		PrintThread mt = new PrintThread("print_thread");
//		PrintThread mt = new PrintThread();
//	      mt.start ();
//	      for (int i = 0; i < 50; i++)
//	           System.out.println ("i = " + i + ", i * i = " + i * i);
//	   }

	/**2
	 * @param args
	 * 	 to see the threads synchronizaiton by time (2 ms is given accroding to processor)
	 */
//	public static void main(String[] args) {
//		CalculatorThread th = new CalculatorThread();
//		th.start();
//		try {
//			Thread.sleep(2); // Sleep for 2 milliseconds
//		} catch (InterruptedException e) {		}
//		System.out.println("pi = " + th.pi + "  "   + sdf.format(new Date()));
//	}
	
	/**3
	 * @param args
	 *  same as 2. but now main thread waits for the other thread to finish.
	 */
//	public static void main(String[] args) {
//		CalculatorThread th = new CalculatorThread();
//		th.start();
//		while (th.isAlive ()){
//	        try
//	        {
//	        	 System.out.println ("waited");
//	            Thread.sleep (1); // Sleep for 10 milliseconds
//	        }
//	        catch (InterruptedException e)
//	        {
//	        }
//	        System.out.println ("no valid pi = " + th.pi);
//		}
//	      System.out.println ("VALID pi = " + th.pi);
//	}
	
	/**4
	 * @param args
	 *  same as 3. but instead join() is used.
	 */
//	public static void main(String[] args) {
//		CalculatorThread th = new CalculatorThread();
//		th.start();
//	        try{
//	        	th.join();
//	        }
//	        catch (InterruptedException e){
//	        }
//	      System.out.println ("VALID pi = " + th.pi);
//	}
	
	
	/**5
	 * 
	 * @param args
	 * get all active threads (no daemons-system-)
	 */
//	public static void main(String[] args) {
//		Thread[] threads = new Thread[Thread.activeCount()];
//		int n = Thread.enumerate(threads);// sayısı
//		for (Thread t :threads){
//			System.out.println (t); //name, priority, thread_group
//		}
//	}
	
	/**6
	 * ObjectLock:
	 * to avoid the RACE CONDITION, the object in @see TransactionThread is synchronized.
	 * expected always as:
	 * <pre>
	 * withdrawal 4444.0
	 * deposit 2222.0
	 * </pre>
	 */
//   public static void main (String [] args)
//   {
//      BasicModel ft = new BasicModel();
//      TransactionThread tt1 = new TransactionThread (ft, "Deposit Thread");
//      TransactionThread tt2 = new TransactionThread  (ft, "Withdrawal Thread");
//      tt1.start ();
//      tt2.start ();
//   }
	
	/**7
	 * since object lock can get holding multiple threads at a time which means bad for performence.
	 * try synchronizing class methods (statics) as: 
	 */
//  public static void main (String [] args)
//  {
//     BasicModel ft = new BasicModel();
//     TransactionThread tt1 = new TransactionThread (ft, "Deposit Thread");
//     TransactionThread tt2 = new TransactionThread  (ft, "Withdrawal Thread");
//     tt1.start ();
//     tt2.start ();
//  }
	/**8
	 * synchronization errors 1: no synchronization
	 * 
	 *  Suppose two threads want to enter the same critical code section.
	 *  To prevent both threads from entering that critical code section simultaneously,
	 *  each thread must attempt to acquire the same lock.
	 *  If each thread attempts to acquire a different lock and succeeds,
	 *  both threads enter the critical code section;
	 *  neither thread has to wait for the other thread to release its lock because the other thread acquires a different lock.
	 *  ex: in TransactionThread class, acquiring lock associated 'this' instead of same object.
	 *  'this' would refer the current thread itself in that case and it means every thread has seperate locks. 
	 */
	
	/**9
	 * synchronization errors 2: dead lock
	 * Two threads and two locks. @see TransactionThreadDeadLock
	 */
//	public static void main(String[] args) {
//		BasicModel ft = new BasicModel();
//	     TransactionThreadDeadLock tt1 = new TransactionThreadDeadLock (ft, "Deposit Thread");
//	     TransactionThreadDeadLock tt2 = new TransactionThreadDeadLock  (ft, "Withdrawal Thread");
//	     tt1.start ();
//	     tt2.start ();
//	}
	
	
	/**10
	 * without any scheduling
	 */
//	public static void main(String[] args) {
//	      new CalculatorThread ("CalcThread A").start ();
//	      new CalculatorThread ("CalcThread B").start ();
//	}
	
	/**11
	 * blocker demonstration
	 * commenting out priority line to see what happens
	 * @see priority inversion
	 * @see priority inheritance
	 * @see time-slicing
	 */
	
//	public static void main(String[] args) {
//		RunningThread rt = new RunningThread();
//		BlockerThread bt = new BlockerThread();
//		bt.setPriority(Thread.NORM_PRIORITY + 1);
//		bt.start();
//		rt.start();
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//		}
//		bt.setFinished(true);
//		rt.setFinished (true);
//	 }
	/**12
	 * for 11 to be more simple yield() method may be used
	 * yield() gives out another turn for threads to be chosen from the pool. 
	 */
	/**
	 * 13
	 * producer consumer
	 * for seeing the importance of wait() nad notify(). Commenting in and out setter and getter in sharedType object will show the correct way.
	 */
//	public static void main(String[] args) {
//		SharedType s = new SharedType();
//		
//		ProducerThread pt = new ProducerThread(s);
//		ConsumerThread ct = new ConsumerThread(s);
//		pt.start();
//		ct.start();
//	}
	
	/**
	 * 14
	 * interrupt for a thread mean wake it form its sleep of wait (join) 
	 */
	
//	public static void main(String[] args) {
//		InterruptedThread ited = new InterruptedThread("ited"); 
//		InterruptorThread itor = new InterruptorThread("itor", ited);
//		
//		ited.start();
//		itor.start();
//	}
	/**15
	 * synchronizing with java executor framework and pool opitmizing experiment
	 */
//	 public static void main(String[] args) {
//		 long start = System.nanoTime();    
//         ExecutorService executor = Executors.newFixedThreadPool(10); //aynıs bizim projelerde spring'in taskExecutor bean'i ile yapılıyor.
//         for (int i = 0; i < 500; i++) {
//                 Runnable worker = new PrintThread();
//                 executor.execute(worker);
//         }
//         // This will make the executor accept no new threads
//         // and finish all existing threads in the queue
//         executor.shutdown();
//         // Wait until all threads are finish
//         try {
//			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//         System.out.println("Finished all threads");
//         long elapsedTime = System.nanoTime() - start;
//         System.out.println(elapsedTime);//pool'u değiştirerek elapsed time'a bakabilirsiniz
// }
	/**16
	 * calalbles and futures of concurrent.java
	 */
	public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Long>> list = new ArrayList<Future<Long>>();
        for (int i = 0; i < 20000; i++) {
                Callable<Long> worker = new SumCallable();
                Future<Long> submit = executor.submit(worker);
                list.add(submit);
        }
        long sum = 0;
        System.out.println(list.size());
        // now retrieve the result
        for (Future<Long> future : list) {
                try {
                	 System.out.println(future.get());
                        sum += future.get();
                } catch (InterruptedException e) {
                        e.printStackTrace();
                } catch (ExecutionException e) {
                        e.printStackTrace();
                }
        }
        System.out.println(sum);
        executor.shutdown();
}
	
}

