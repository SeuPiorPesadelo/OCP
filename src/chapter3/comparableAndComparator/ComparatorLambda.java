package chapter3.comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

	public static void main(String...strings ) {
		
		//instancia da Interface usando classe anonima
		Comparator<DuckComparable> c = new Comparator<DuckComparable>() {
			@Override
			public int compare(DuckComparable d1, DuckComparable d2) {
				return d1.getId() - d2.getId();
			}
		};
		
		List<DuckComparable> list = listaDePatos();
		
		System.out.println("Ordenando por Comparable");
		Collections.sort(list);
		list.forEach(l -> System.out.println(l));
		
		System.out.println("Ordenando por Comparator");
		Collections.sort(list, c);
		list.forEach(l -> System.out.println(l));
		
		//outra maneira de implementar, jah q Comparator eh uma Interface Funcional
		Comparator<DuckComparable> dc = (d1, d2) -> d2.getId() - d1.getId();
		System.out.println("Ordem decrescente c/ Comparator");
		Collections.sort(list, dc);
		list.forEach(l -> System.out.println(l));
	}

	private static List<DuckComparable> listaDePatos() {
		List<DuckComparable> list = new ArrayList<>();
		list.add(new DuckComparable(1, "Patolino"));
		list.add(new DuckComparable(2, "Astolfo"));
		return list;
	}
}
