package chapter4.stream;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollecttorsStream {

	public static void main(String[] args) {
		usoBasico();
		collectorsComMap();
		collectorsComGroupingBy();
	}

	private static void usoBasico() {
		Stream<String> s = Stream.of("Tigre", "Elefante", "Urso", "Urubu");
		String a = s.filter(x -> x.startsWith("U")).collect(Collectors.joining(", "));
		System.out.println("Collectors.joining(', ') " + a);

		Stream<String> f = Stream.of("Tigre", "Elefante", "Urso", "Urubu");
		TreeSet<String> ts = f.filter(x -> x.startsWith("U")).collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Collectors.toCollection(TreeSet::new) " + ts);
	}

	private static void collectorsComMap() {
		Stream<String> s = Stream.of("Tigre", "Elefante", "Urso", "Urubu");
		Map<String, Integer> map = s.collect(Collectors.toMap(x -> x, String::length));
		System.out.println(map);

		Stream<String> s1 = Stream.of("Tigre", "Elefante", "Urso", "Urubu");
		Map<Integer, String> map1 = s1 // o q será a chave,chave aqui,
										// BinaryOperator mergiando caso exista
										// mais de 1 na mesma key
				.collect(Collectors.toMap(String::length, key -> key, (value1, value2) -> value1 + ", " + value2));
		System.out.println(map1);
	}

	private static void collectorsComGroupingBy() {
		Stream<String> s = Stream.of("Tigre", "Elefante", "Urso", "Urubu");
		Map<Integer, List<String>> map = s.collect(Collectors.groupingBy(String::length));
		map.get(5).forEach(p -> System.out.print(p));// TigreUrubu
	}
}
