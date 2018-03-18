package chapter3.methodReferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class MetodosStaticos {

	public static void main(String... strings) {
		//metodo de referencia estático
		Consumer<List<Integer>> consumer = Collections::sort;
		// equivalente em lambda
		// Consumer<List<Integer>> consumer = lis -> Collections.sort(lis);

		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(3);
		consumer.accept(list);//interface funcional consumer aceita 1 parametro e retorna void
		list.forEach(p -> System.out.println(p));
	}
}
