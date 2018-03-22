package chapter3.bounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ErrorsAndTricks {

	public static void main(String... strings) {
		instanciaDeTiposGenericos();
		interacaoDeUmHashSet();
	}

	private static void instanciaDeTiposGenericos() {
//		 HashSet<Number> hs = new HashSet<Integer>();//Nao compila, tipo
		// genérico nao eh compativel
		HashSet<? extends Number> hs = new HashSet<Integer>();// aceita qualquer
																// coisa de
																// extends
																// Number
		// List<Integer> l = new ArrayList<? extends Number>();//Nao compila, pq
		// eh necessario uma definicao na hr de instanciar
		// List<Number> l1 = new ArrayList<? super Integer>();//Nao compila, pq
		// eh necessario uma definicao na hr de instanciar
		TreeMap<Integer, Integer> m = new TreeMap<>();
		m.put(1, 1*1);
		m.get(1);
	}

	private static void interacaoDeUmHashSet() {
		// create hash set
		Set<Number> n = new HashSet<>();
		// populate hash set
		n.add(123);
		n.add(new Double("3.14"));
		n.add(1.5F);
		n.add(new Integer(666));

		// a saida desses numeros eh indeterminada (fora de ordem)
		Iterator i = n.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
