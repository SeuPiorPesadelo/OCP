package chapter7.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

//ha 5 formas de se criar threads
public class CriacaoDeThreads {

	public static void main(String... strings) {

		// execucao imediata, retorna ExecutorService
		criacaoSingleThread();
		criacaoCachedThreadPool();
		criacaoFixedTrheadPool();

		// execucao agendada, retorna ScheduledExecutorService
		criacaoSingleThreadAgendada();
		criacaoThreadPoolAgendada();
	}

	private static void criacaoSingleThread() {
		//mais simples de todas
		ExecutorService e = Executors.newSingleThreadExecutor();
	}

	private static void criacaoCachedThreadPool() {
		// JVM tem controle total, indicado para elevado numero de tarefas
		// curtas
		ExecutorService e = Executors.newCachedThreadPool();
	}

	private static void criacaoFixedTrheadPool() {
		// JVM tem controle total, porem de um numero fixo de Threads
		ExecutorService e = Executors.newFixedThreadPool(3);
	}

	private static void criacaoSingleThreadAgendada() {
		// singleThread c/ recurso de agendamento
		ScheduledExecutorService e = Executors.newSingleThreadScheduledExecutor();
		ScheduledFuture<?> future = e.schedule(() -> System.out.println("single thread agendada"), 1, TimeUnit.SECONDS);
		System.out.println("future.getDelay: " + future.getDelay(TimeUnit.MICROSECONDS));
		e.shutdown();
	}

	private static void criacaoThreadPoolAgendada() {
		// JVM controla um numero fixo de Threads, agora com recurso de
		// agendamento
		ScheduledExecutorService e = Executors.newScheduledThreadPool(3);
		ScheduledFuture<?> scheduleAtFixedRate = e.scheduleAtFixedRate(()-> System.out.println("future.getDelay: "), 1, 2, TimeUnit.SECONDS);
	}
}
