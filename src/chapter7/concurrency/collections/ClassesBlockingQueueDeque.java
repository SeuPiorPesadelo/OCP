package chapter7.concurrency.collections;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Tem os mesmo métodos de uma Queue (offer,poll,peek, remove) mas tem 2
 * adicionais. LinkedBlockingQueue implementa Queue e BlockingQueue
 * 
 * @author Lucas
 *
 */
public class ClassesBlockingQueueDeque {

	public static void main(String... strings) {
		
		try {

			linkedBlockingQueue();
			linkedBlockingDeque();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void linkedBlockingDeque() throws InterruptedException {
		BlockingDeque<Integer> block = new LinkedBlockingDeque<>();
		
		// um offerFirst() q esperará um tempo até sua execucao p/ ofertar na primeira posicao
		block.offerFirst(3, 2, TimeUnit.SECONDS);
		// um offerFirst() q esperará um tempo até sua execucao p/ ofertar na ultima posicao
		block.offerLast(2, 2, TimeUnit.SECONDS);
		block.offer(1);
		block.offer(0);
		
		// e um poll() remove e retorna o primeiro da fila
		block.poll();
		block.pollFirst(2, TimeUnit.SECONDS);//faz a mesma coisa, soh q com um prazo p/ executar
		block.pollLast(2, TimeUnit.SECONDS);//recebe e remove o ultimo, soh q com um prazo p/ executar
		System.out.println("LinkedBlockingDeque: " + block);
	}

	private static void linkedBlockingQueue() throws InterruptedException {
		BlockingQueue<Integer> block = new LinkedBlockingQueue<>();
		
		// um offer() q esperará um tempo até sua execucao
		block.offer(1, 2, TimeUnit.SECONDS);

		// e um poll() q esperará um tempo até sua execucao
		block.poll(2, TimeUnit.SECONDS);
		System.out.println("LinkedBlockingQueue: " + block);
	}
}
