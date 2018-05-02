package chapter7.concurrency.collections;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 
 * @author Lucas
 *
 */
public class ClassesCopyOnWriteArrayListESet {

	public static void main(String... strings) {
		
		Set<Integer> list = new CopyOnWriteArraySet<>(Arrays.asList(1,2,3,4));
		
		for (Integer i : list) {
			System.out.println("Conteudo de list: " + i);
			list.add(i + 4);// adcionar� 5,6,7,8
			//list continuar� referenciando a Collection inicial
		}
		
		//pega a mesma refer�ncia, list, s� q agora constar� os elementos adicionados anteriormente
		for (Integer i : list) {
			System.out.println("Conteudo de list: " + i);
		}
	}
}
