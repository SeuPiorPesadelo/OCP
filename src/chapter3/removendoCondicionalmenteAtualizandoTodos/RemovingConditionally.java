package chapter3.removendoCondicionalmenteAtualizandoTodos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class RemovingConditionally {

	public static void main(String... strings) {
		removendoCondicionalmente();
		atualizandoTodos();
		atualizandoValoresDumMap();
		margeandoValoresDumMap();
	}

	private static void removendoCondicionalmente() {
		// assinatura do metodo removeIf()
		// public boolean removeIf(Predicate<? super E> parameter);

		List<String> list = new ArrayList<>();
		list.add("magico");
		list.add("assistente");
		// usa um Predicate p/ determinar o q o removeIf() ira retirar
		list.removeIf(s -> s.startsWith("a"));
		list.forEach(System.out::println);
	}

	private static void atualizandoTodos() {
		// assinatura do metodo removeIf()
		// public void replaceAll(UnaryOperator<E> parameter);
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		list.replaceAll(i -> i * 2);//multiplica todos por 2
//		list.replaceAll(i -> 1); //passa todos pra 1
		list.forEach(System.out::print);
		System.out.println();
	}
	
	private static void atualizandoValoresDumMap() {
		Map<String, String> map = new HashMap<>();
		map.put("Lucas", "locura sem limites");
		map.put("Jose", null);
		
		//putIfAbsent adiciona se a chave estiver ausente, ou se seu valor for null
		//em chaves jah existentes com valores != null, nada eh modificado
		map.putIfAbsent("Lucas", "sem locura");
		map.putIfAbsent("Jose", "sem locura");
		map.putIfAbsent("Joao", "sem locura");
		
		System.out.println(map);//{Joao=sem locura, Jose=sem locura, Lucas=locura sem limites}
	}
	
	private static void margeandoValoresDumMap() {
		//usa a interface funcional BiFunction implementando como deve ser o comportamento do merge
		//no caso, quem tem o nome mais comprido eh
//		BiFunction<String, String, String> mapper = (string1, string2) -> string1.length() > string2.length() ? string1 : string2;
		
		//retornando null
		BiFunction<String, String, String> mapper = (string1, string2) -> null;
		
		Map<String, String> map = new HashMap<>();
		map.put("Lucas", "locura sem limites");
		map.put("Jose", null);//se nao tem o q comparar, o merge adiciona o q tem na chamada dele
		
		map.merge("Lucas", "locurada muito loca", mapper);
		map.merge("Jose", "locura", mapper);
		map.merge("Adicionado", "Pq nao existia no map inicial", mapper);
		
		System.out.println(map);
	}

}
