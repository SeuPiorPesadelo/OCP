package chapter7.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterfaceExecutorService {

	public static void main(String... strings) {
		ExecutorService exe = null;
		try {
			System.out.println("Comecou o main()");
			exe = Executors.newSingleThreadExecutor();
			exe.execute(() -> System.out.println("COMECOU newSingleThreadExecutor!"));
			exe.execute(() -> {
				for (int i = 0; i < 5; i++)
					System.out.println("dentro do For " + i);
			});
			exe.execute(() -> System.out.println("TERMINOU newSingleThreadExecutor!"));
			System.out.println("Terminou o main()");
		} finally {
			if (exe != null) {
				//sem o shutdown, ficará eternamente executando
				exe.shutdown();
			}
		}
	}
}
