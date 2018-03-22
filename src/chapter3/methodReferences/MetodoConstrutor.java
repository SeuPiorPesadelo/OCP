package chapter3.methodReferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class MetodoConstrutor {

	public static void main(String... strings) {
		// metodo de referencia chamando Construtores
		// sao metodos de referencia q nao recebem parametros e retornam uma
		// instancia qualquer
		Supplier<ArrayList> sup = ArrayList::new;
		// equivalente em lambda
		// Supplier<ArrayList> sup = () -> new ArrayList();

		List<Integer> list = sup.get();
		list.add(4);
		list.add(0);
		list.add(7);
		list.add(6);
		System.out.println(Collections.binarySearch(list, 5));// binarySearch
																// funciona
																// independentemente
																// da ordenação
																// crescente/descrescente da
																// lista
		list.forEach(p -> System.out.println(p));
	}
}
