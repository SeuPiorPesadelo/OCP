package chapter7.concurrency.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	}

	private static void trabalhandoComReduce() {
		System.out.println("Reduce em acao !");
		System.out.println(Arrays.asList('o', 'r', 'n', 'i', 't', 'o', 'r', 'r', 'i', 'n', 'c', 'o').parallelStream()
				.reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3));

//		System.out.println(Arrays.asList(1, 2, 3,4,5,6,7,8,9).parallelStream().reduce(0, (a, b) -> (a + b), (x, y) -> (x - y)));
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
}
