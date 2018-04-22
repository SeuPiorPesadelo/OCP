package chapter7.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ClasseFuture {

	private static int count = 0;

	public static void main(String... strings) {
		ExecutorService exe = null;
		try {
			exe = Executors.newSingleThreadExecutor();
			
			Future<?> futureComRunnable = exe.submit(() -> {//submetendo um Runnable
				for (int i = 0; i < 500; i++)
					count++;
			});
			Future<?> futureComCallable = exe.submit(() -> 1); //aqui seria um Callable
			
			Object o = futureComRunnable.get(10, TimeUnit.SECONDS);
			System.out.println(o);//como é um Runnable(retorna void), printará null
			
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			if (exe != null) {
				exe.shutdown();
			}
		}
	}

}
