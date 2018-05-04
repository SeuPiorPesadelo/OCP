package chapter7.concurrency.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Pode se criar a partir de 2 jeitos: chamando .parallel() a partir de uma
 * Stream já existente OU .parallelStream() a partir de uma Collection
 * 
 * @author Lucas
 *
 */
public class PerallelStreams {

	public static void main(String... strings) {
		systemOutPrintUsandoParallel();
		diferencaDePerformance();
		trabalhandoComReduce();
		trabalhandoComCollect();
		trabalhandoComCyclicBarrier();
	}

	private static void trabalhandoComCollect() {
		System.out.println("Collect em acao !");

		// Collect com 3 argumentos
		Stream<String> stream1 = Stream.of("w", "o", "l", "f").parallel();
		SortedSet<String> skipListSet = stream1.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
		System.out.println(skipListSet);

		// Collect com 1 argumento
		Stream<String> stream2 = Stream.of("w", "o", "l", "f").parallel();
		Set<String> set = stream2.collect(Collectors.toSet());
		System.out.println(set);

		// Collect com 1 argumentos usando um Collectors de 3 argumentos
		Stream<String> stream3 = Stream.of("Sapos", "Tigres", "Ursos").parallel();
		ConcurrentMap<Integer, String> map = stream3
				.collect(Collectors.toConcurrentMap(String::length, v -> v, (s1, s2) -> s1 + ", " + s2));
		System.out.println(map);

		// Collect com 1 argumentos usando um Collectors de 1 argumento
		Stream<String> stream4 = Stream.of("Sapos", "Tigres", "Ursos").parallel();
		ConcurrentMap<Integer, List<String>> maps = stream4.collect(Collectors.groupingByConcurrent(String::length));
		System.out.println(maps);
	}

	private static void trabalhandoComReduce() {
		System.out.println("Reduce em acao !");
		System.out.println(Arrays.asList('o', 'r', 'n', 'i', 't', 'o', 'r', 'r', 'i', 'n', 'c', 'o').parallelStream()
				.reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3));

		// System.out.println(Arrays.asList(1, 2,
		// 3,4,5,6,7,8,9).parallelStream().reduce(0, (a, b) -> (a + b), (x, y)
		// -> (x - y)));
	}

	private static void diferencaDePerformance() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(i);
		}

		double start = System.currentTimeMillis();
		processAllRecord(list);
		System.out.println("Demorou " + ((System.currentTimeMillis() - start) / 1000) + " segundos");
	}

	private static void systemOutPrintUsandoParallel() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

		// printa totalmente desordenado
		list.parallelStream().forEach(i -> System.out.println("parallelStream: " + i));

		// agora ordenado
		list.parallelStream().forEachOrdered(i -> System.out.println("parallelStream c/ forEachOrdered: " + i));

	}

	static int processRecord(int input) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return input + 1;
	}

	static void processAllRecord(List<Integer> list) {
		// count conta quanto elementos existem dentro da Collection após o
		// processamento paralelo
		System.out.println("Contagem: " + list.parallelStream().map(i -> processRecord(i)).count());
	}

	private static void trabalhandoComCyclicBarrier() {
		System.out.println("Trabalhando com CyclicBarrier");

		// cria a instancia q executará a acao
		LionManager m = new LionManager();
		// 4 Threads
		ExecutorService exe = Executors.newFixedThreadPool(4);

		// Se colocar 5, esse CyclicBarrier esperará eternamente. Se colocar 3,
		// aguardará 3 Threads e liberará p/ a próxima execucao

		CyclicBarrier c1 = new CyclicBarrier(4);
		// pode-se colocar um Runnable como segundo parâmetro
		CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("Jaulas Limpas!"));

		for (int i = 0; i < 4; i++) {// dispara 4 Threads
			exe.submit(() -> m.executaTodasAsTarefas(c1, c2));
		}
		exe.shutdown();
	}
}

class LionManager {
	
	void removeOsLeoes() {
		System.out.println("Removendo os Leoes");
	}

	void limpaAsJaulas() {
		System.out.println("Limpando as jaulas");
	}

	void adicionaOsLeoes() {
		System.out.println("Adicionando os Leoes");
	}

	void executaTodasAsTarefas(CyclicBarrier c1, CyclicBarrier c2) {
		try {
			removeOsLeoes();
			c1.await();// espera a execucao das 4 Threads
			limpaAsJaulas();
			c2.await();// espera a execucao das 4 Threads
			adicionaOsLeoes();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}