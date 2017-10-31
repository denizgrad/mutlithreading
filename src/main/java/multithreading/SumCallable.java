package multithreading;

import java.util.concurrent.Callable;

public class SumCallable implements Callable<Long>{

    @Override
    public Long call() throws Exception {
            long sum = 0;
            for (long i = 0; i <= 100; i++) {
                    sum += i;
            }
            return sum;
    }

    public static void main(String[] args) {
    	System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
