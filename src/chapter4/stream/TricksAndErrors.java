package chapter4.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TricksAndErrors {

	public static void main(String[] args) {
		streamInfinitaIterateComNoneMatch();
		streamGenerateAllMatch();
		preIncrementoComStream();
		functionComMesmoComportamentoqueSupplier();
		acharMaiorNumero();

		List<Integer> e = IntStream.range(1, 6).mapToObj(x -> x).collect(Collectors.toList());
		e.forEach(System.out::println);
		
		System.out.println("Usando o metodo .max() da Stream");
		List<Integer> ls = Arrays.asList(3, 4, 6, 9, 2, 5, 7);
		System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b));// 9
		System.out.println(ls.stream().max(Integer::max).get());// 3

		System.out.println(ls.stream().max((a, b) -> Integer.compare(a, b)).get());// 9
		System.out.println(ls.stream().max(Integer::compare).get());// 9

		System.out.println(ls.stream().max((a, b) -> a > b ? a : b));// Optional[3]
	}

	private static void streamGenerateAllMatch() {
		Stream<String> s = Stream.generate(() -> "cachorro");
		boolean c = s.allMatch(b -> b.isEmpty());//anyMatch e noneMatch executam infinitamente
		System.out.println(c);
	}

	private static void streamInfinitaIterateComNoneMatch() {
		Predicate<String> p = x -> x.length() > 3;
		//Stream.iterate vai sempre iterando, q coisa nao?
		Stream<String> s = Stream.iterate("-", s1 -> s1 + s1);//- -- ----
		boolean b1 = s.peek(x -> System.out.print(" " + x)).noneMatch(p); 
		System.out.println("Predicate em Stream infinita: " + b1);
	}
	
	private static void preIncrementoComStream() {
		//nao compila pq o iterate devolve Integer e o Collectors retorna uma String
//		Stream.iterate(1, x -> x++).limit(5).map(x -> x).collect(Collectors.joining());
		
		//Compila mas printa 11111 (cinco numeros 1s)
		String result = Stream.iterate(1, x -> x++).limit(5).map(x -> "" + x).collect(Collectors.joining());
		System.out.println("SEM pre-incremento no .iterate(): " + result);
		
		//Agora com pré-incremento a Stream itera devolvendo 12345
		String r = Stream.iterate(1, x -> ++x).limit(5).map(x -> "" + x).collect(Collectors.joining());
		System.out.println("COM pre-incremento no .iterate(): " + r);
	}
	
	private static void functionComMesmoComportamentoqueSupplier(){
		Supplier<Long> ls = () -> new Long("10");
		Function<String, Long> f = Long::new;
		Long l = f.apply("10");
		System.out.println(l + " usando Function<T,R> e " + ls.get() + " com Supplier<R>");
	}
	
	private static void acharMaiorNumero() {
		List<Integer> ls = Arrays.asList(10, 47, 33, 23);
		
		//o metodo Comparator.comparing() pega no parametro um objeto q implementa Comparable e usa essa
		//implementacao p/ estabelecer um Comparator
		int maiorComMax = ls.stream().max(Comparator.comparing(a -> a)).get();//.get() eh p/ retornar um int
		
		//como foi passado um seed, retornará um Integer, senao, retornaria um Optional
		int maiorComReduce = ls.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
		
		System.out.print("maior com max:" + maiorComMax + " e maior com reduce: " + maiorComReduce);
		System.out.println();
	}
	
	private static void comportamentoIgualAoComputeIfAbsent() {
		//inicializacao
		String name = "Lucas";
		Double value = 6.9;
		Map<String, List<Double>> groupedValues = new HashMap<>();

		//processo q será simplificado
		List<Double> values = groupedValues.get(name);
		if (values == null) {
			values = new ArrayList<Double>();
			groupedValues.put(name, values);
		}
		values.add(value);

		//processo simplificado       key             Function
		groupedValues.computeIfAbsent(name, (a) -> new ArrayList<Double>()).add(value);
	}
}
