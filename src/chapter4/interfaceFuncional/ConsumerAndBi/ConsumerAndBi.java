package chapter4.interfaceFuncional.ConsumerAndBi;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerAndBi {

	public static void main(String...strings) {
		//Consumer eh usado p/ pegar o parametro e fazer alguma coisa com ele
		//por exemplo um Collections.sort num ArrayList
		Consumer<String> c = System.out::println;
		c.accept("Consumer");
		
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> bc = map::put;
		bc.accept("Lucas", 69);
		System.out.println(map);
	}
}
