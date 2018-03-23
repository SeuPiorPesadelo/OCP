package chapter4.interfaceFuncional.functionAndBi;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionAndBi {

	public static void main(String...strings) {
		
		//recebe um parametro, faz algum processo e retorna um outro tipo
		Function<String, Integer> f = String::length;
		BiFunction<String, String, String> b = String::concat;
		
		System.out.println(f.apply("Lucas"));
		System.out.println(b.apply("Lucas", " locao"));
	}
}
