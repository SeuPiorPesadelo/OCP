package chapter3.methodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MetodoConstrutor {

	public static void main(String... strings) {
		// metodo de referencia chamando Construtores
		// sao metodos de referencia q nao recebem parametros e retornam uma instancia qualquer
		Supplier<ArrayList> sup = ArrayList::new;
		// equivalente em lambda
		// Supplier<ArrayList> sup = () -> new ArrayList();

		List<Integer> list = sup.get();
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(3);
		list.forEach(p -> System.out.println(p));
	}
}
