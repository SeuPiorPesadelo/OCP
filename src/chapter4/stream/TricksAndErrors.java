package chapter4.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TricksAndErrors {

	public static void main(String[] args) {
		streamInfinitaIterateComNoneMatch();
		streamGenerateAllMatch();
		preIncrementoComStream();
		functionComMesmoComportamentoqueSupplier();
		acharMaiorNumero();
		mapeamentosDiferentesNoMapTo();
		replaceAllAceitaUnaryOperator();

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

	private static void replaceAllAceitaUnaryOperator() {
		List<String> letters1 = Arrays.asList("j", "a", "v","a");
		UnaryOperator<String> op = s -> s.toUpperCase();
		letters1.replaceAll(op);
		letters1.forEach(System.out::print);
		System.out.println();
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
		
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17);
		Stream<Integer> primeStream = primes.stream();
		Predicate<Integer> test1 = k -> k < 10;
		primeStream.collect(Collectors.partitioningBy(test1, Collectors.counting())).values()
				.forEach(System.out::print);
		System.out.println();
		
		DoubleStream sd = DoubleStream.of(1.1,1.1,1.1);
		OptionalDouble sum = sd.average();
		List<String> letters = Arrays.asList("j", "a", "v","a");
		System.out.print(letters.stream().collect(Collectors.joining(", ")));//joining() ou recebe soh uma String ou nao recebe nada 
		System.out.println();
		Optional<Double> price = Optional.ofNullable(null);
		System.out.println(price.orElseGet(() -> 6.9));
		
		
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
	
	private static void mapeamentosDiferentesNoMapTo(){
		List<Book> books = Arrays.asList(new Book("Gone with the wind", 10.0), new Book("Atlas Shrugged", 10.0),
				new Book("Freedom at Midnight", 5.0), new Book("Gone with the wind", 5.0));
		
		//no mapToDouble pode ser usado uma Funtion<T,R> já com algum tipo de filtro
		double somaComFunctionNoMapToDouble = books.stream().mapToDouble(b -> b.getPrice() > 5 ? b.getPrice() : 0.0)
				.sum();
		
		//Ou pode ser usado um Function<T,R> p/ um mapeamento normal e com um filter(Predicate) antes ou depois
		double sumComPredicateNoFilter = books.stream().mapToDouble(b -> b.getPrice()).filter(b -> b > 5.0).sum();
		System.out.println("soma Com Function No Map To Double " + somaComFunctionNoMapToDouble
				+ ", soma Com Predicate No Filter " + sumComPredicateNoFilter);
	}
}
