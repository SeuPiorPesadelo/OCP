package chapter3.Collections;

import java.util.ArrayDeque;

public class Queues {

	public static void main(String... args) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		preencheEPrinta(q);
		
		System.out.print("push() adiciona um elemento na frente da fila: 666");
		q.push(666);
		System.out.println();
		System.out.println("element() retorna o primeiro elemento (FIFO), lanca Exception se nao encontrar 	" + q.element());
		System.out.println("peek() retorna o primeiro elemento (FIFO), retorna Null se nao encontrar 	" + q.peek());
		System.out.println("pop() remove e retorna o primeiro elemento (FIFO), lanca Exception se nao encontrar " + q.pop());
		System.out.println("remove() remove e retorna o primeiro elemento (FIFO), lanca Exception se nao encontrar " + q.remove());
		System.out.println("poll() remove e retorna o primeiro elemento (FIFO), retorna Null se nao encontrar  	" + q.poll());
		q.forEach(s -> System.out.print(s));
	}

	private static void preencheEPrinta(ArrayDeque<Integer> q) {
		for (int i = 0; i < 10; i++) {
			q.offer(i);// offer insere no fim da fila
		}
		q.forEach(s -> System.out.print(s));
		System.out.println();
	}
}
