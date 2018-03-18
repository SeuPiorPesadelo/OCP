package chapter3.methodReferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import chapter3.comparableAndComparator.DuckComparator;

public class MethodReferences {
	
	public static void main(String...strings ) {
		 
		//chamada de metodo de referencia DuckHelper::comparaId
		Comparator<DuckComparator> comparator = DuckHelper::comparaId;
		
		List<DuckComparator> list = new ArrayList<>();
		list.add(new DuckComparator(2, "Patolino"));
		list.add(new DuckComparator(1, "Donald"));
		Collections.sort(list, comparator);
		list.forEach(p -> System.out.println(p));
	}
}
