package chapter7.concurrency.collections;

import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Collections: ConcurrentHashMap, ConcurrentLinkedDeque e ConcurrentLinkedQueue
 * seguem o mesmo comportamento q suas Collections naturais
 * 
 * @author Lucas
 *
 */
public class CollectionsQueSeguemMesmoComportamento {

	public static void main(String... strings) {
		HashMapConcorrent();
		LinkedQueueConcorrente();
		LinkedDequeConcorrente();
	}
	
	private static void HashMapConcorrent() {
		Map<String, Integer> map = new ConcurrentHashMap<>();
		map.put("Leao", 1);
		map.put("Capivara", 2);
		map.put("Avestruz", 3);
		
	}

	private static void LinkedQueueConcorrente() {
		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		queue.offer(69);//true if the element was added to this queue, else false. Como se fosse um add() só q s/ Exception
		queue.add(1);//Sempre retorna true, ou retorna Exception se nao conseguir adicionar
		
		System.out.println(queue.peek());//recebe mas nao retira o 1º elemento da fila
		System.out.println(queue.poll());//recebe e remove o 1º elemento da fila
	}

	private static void LinkedDequeConcorrente() {
		//é um Queue só q com final nas duas pontas da fila. Double Queue = Deque
		Deque<Integer> deque = new ConcurrentLinkedDeque<>();
		
		//Contem metodos como: offerLast(), offersFirst(), pollLast(), pollFirst()
		deque.offerFirst(1);
		deque.offerFirst(2);
		deque.offerFirst(3);
		for (Integer i : deque) {
			System.out.println("numeros dentro de Deque: " + i);
		}
		deque.removeLast();//removerá o 1
		System.out.println(deque.pollFirst());//removerá e devolverá o 3
	}

}
