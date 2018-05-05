package chapter7.concurrency.forkJoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {
	public static void main(String... strings) {
		Double[] pesos = new Double[10];
		
		ForkJoinTask<Void> task1 = new PesarAnimaisComRecursiveAction(0, pesos.length, pesos);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task1);
		Arrays.asList(pesos).forEach(System.out::println);
		
		System.out.println("------------------------------------------------------");
		
		ForkJoinTask<Double> task2 = new PesarAnimaisComRecursiveTask(0, pesos.length, pesos);
		Double somaDosPesos = pool.invoke(task2);
		System.out.println("Soma dos Pesos usando RecursiveTask<Double>: " + somaDosPesos);
	}
}

/**
 * RecursiveAction trabalha com Runnable
 * 
 * @author Lucas
 *
 */
class PesarAnimaisComRecursiveAction extends RecursiveAction {

	private static final long serialVersionUID = 6484930676988421596L;
	private int start;
	private int end;
	private Double[] pesos;

	public PesarAnimaisComRecursiveAction(int start, int end, Double[] pesos) {
		this.start = start;
		this.end = end;
		this.pesos = pesos;
	}

	/**
	 * Pesa os animais de 3 em 3
	 * 
	 */
	@Override
	protected void compute() {
		if (end - start <= 3) {
			// sorteia um peso e atribui ao intervalo de indice respectivo
			for (int i = start; i < end; i++) {
				pesos[i] = (double) new Random().nextInt(100);
				System.out.println("Animal " + i + " pesado.");
			}
		} else {
			int meio = start + ((end - start) / 2);// acha a metade obedecendo o seu intervalo
			System.out.println("Start: " + start + ", meio: " + meio + ", end: " + end);
			// quebra no meio e invoca duas Threads
			invokeAll(new PesarAnimaisComRecursiveAction(start, meio, pesos),
					new PesarAnimaisComRecursiveAction(meio, end, pesos));
		}
	}

}

/**
 * RecursiveTask trabalha com Callable, ou seja, dah retorno
 * 
 * @author Lucas
 *
 */
class PesarAnimaisComRecursiveTask extends RecursiveTask<Double> {

	private static final long serialVersionUID = 8444933646006786597L;
	private int start;
	private int end;
	private Double[] pesos;

	public PesarAnimaisComRecursiveTask(int start, int end, Double[] pesos) {
		this.start = start;
		this.end = end;
		this.pesos = pesos;
	}

	/**
	 * Pesa os animais de 3 em 3
	 * 
	 */
	@Override
	protected Double compute() {
		if (end - start <= 3) {
			//variavel somadora no bloco base
			double sum = 0;
			
			// sorteia um peso e atribui ao intervalo de indice respectivo
			for (int i = start; i < end; i++) {
				pesos[i] = (double) new Random().nextInt(100);
				System.out.println("Animal " + i + " pesado.");
				sum += pesos[i];
			}
			return sum;
		} else {
			int meio = start + ((end - start) / 2);// acha a metade obedecendo o seu intervalo
			System.out.println("Start: " + start + ", meio: " + meio + ", end: " + end);
			
			//pega a metade incial e executa em uma Thread separada usando o .fork()
			RecursiveTask<Double> otherTask = new PesarAnimaisComRecursiveTask(start, meio, pesos);
			otherTask.fork();
			
			//espera a execucao da otherTask usando o .join() p/ disparar a metade final, depois soma os pesos
			return new PesarAnimaisComRecursiveTask(meio, end, pesos).compute() + otherTask.join();
		}
	}

}
