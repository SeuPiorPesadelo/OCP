package chapter7.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AgendamentoDeThreads {

	public static void main(String... strings) {
		agendamentos();
		trabalhandoComIntervalos();
	}

	private static void agendamentos() {
		ScheduledExecutorService service = null;

		Runnable task1 = () -> System.out.println("Agendado com Runnable");
		Callable<Integer> task2 = () -> {
			System.out.println("Agendado com Callable");
			return 1;
		};
		service = Executors.newSingleThreadScheduledExecutor();
		Future<?> f1 = service.schedule(task1, 3, TimeUnit.SECONDS);// parametros(tarefa, deleyinicial, UnidadeDoDelay)
		Future<?> f2 = service.schedule(task2, 4, TimeUnit.SECONDS);

		try {
			System.out.println("Pegando o Future da tarefa 1: " + f1.get());// .get() soh executa depois q a tarefa termina
			System.out.println("Pegando o Future da tarefa 2: " + f2.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		if (service != null) {
			service.shutdown();
		}
	}
	
	private static void trabalhandoComIntervalos() {
		ScheduledExecutorService service = null;
		Runnable task1 = () -> {
			try {
				System.out.println("Esperando 1 segundos");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		service = Executors.newSingleThreadScheduledExecutor();
		                                // parametros(tarefa, deleyinicial, intervalo, UnidadeDoTempo)
		Future<?> f1 = service.scheduleWithFixedDelay(task1, 0, 2, TimeUnit.SECONDS);
		System.out.println("terminou");
	}
}
