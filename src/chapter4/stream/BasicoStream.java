package chapter4.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicoStream {

	public static void main(String[] args) {

		List<String> lista = Arrays.asList("Lucas", "Astolfo", "Arnaldo", "Paulo");
		Stream<String> streamNomes1 = lista.stream();
		// apos o uso da Stream streamNomes1 ela sera terminada,
		// logo, sera necessário a criacao de outra, no caso, streamNomes2

		// System.out.println(streamNomes1.count());count eh uma das operacoes
		// terminais

		List<String> listPessoas = streamNomes1.filter(s -> s.startsWith("A")).collect(Collectors.toList());

		Stream<String> streamNomes2 = lista.stream();
		Set<String> setPessoas = streamNomes2.filter(s -> s.startsWith("A")).collect(Collectors.toSet());

		System.out.println(listPessoas);
		System.out.println(setPessoas);

		Stream<Double> randons = Stream.generate(Math::random);
		randons.findAny().ifPresent(System.out::println);

		metodoReduce();
		metodoCollect();
		Stream<Integer> asd = Stream.iterate(1, x -> x+1); //Stream infinita
		asd.filter(x -> x % 2 == 0).limit(5).peek(System.out::print).forEach(System.out::print);//224466881010
		
		System.out.println();
		IntStream.range(1, 6).forEach(System.out::print);//printa 12345
	}

	private static void metodoReduce() {
		Stream<Integer> streamInt = Stream.of(2, 3, 4);
		int x = streamInt.reduce(1, (int1, int2) -> int1 * int2);
		System.out.println("Reduce de 2,3 e 4 COM identificador: " + x);

		Stream<Integer> streamInt1 = Stream.of(2, 3, 4);
		Optional<? extends Integer> op = streamInt1.reduce((int1, int2) -> int1 * int2);
		op.ifPresent(o -> System.out.println("Reduce de 2,3 e 4 SEM identificador: " + o));

		Stream<Integer> empty = Stream.empty();
		int opEmpty = empty.reduce(1, (int1, int2) -> int1 * int2);
		System.out.println("Reduce de Stream.empty() COM identificador 1: " + opEmpty);

		Stream<Integer> apenas2 = Stream.of(2);
		Optional<Integer> op2 = apenas2.reduce((int1, int2) -> int1 * int2);
		System.out.println("Reduce de Stream só com o nº 2 (aqui eh independente de identificador): " + op2.get());

		// terceira assinatura do metodo reduce eh:
		// <U> U reduce(U identity, BiFunction<U, ? super T,U> accumulator, BinaryOperator<U> combiner)
		BinaryOperator<Integer> bo = (a, b) -> a * b;
		Stream<Integer> asd = Stream.of(1, 2, 3);
		System.out.print("Com a assinatura <U> U reduce(U identity, BiFunction<U, ? super T,U> accumulator, BinaryOperator<U> combiner): ");
		System.out.println(asd.reduce(1, bo, bo)); // 6
	}

	private static void metodoCollect() {
		//tem 2 assinaturas:
		//<R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R,R> combiner)
		//<R,A> R collect(Collector<? super T,A,R> collector)
		
		Stream<String> streamString = Stream.of("l", "o", "b", "o").parallel();
												//fornece o Obj		realiza a operacao		faz o merge de tudo, util quando usado StreamParallel	
		StringBuilder sb = streamString.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(".collect() " + sb);
		
	}
}
