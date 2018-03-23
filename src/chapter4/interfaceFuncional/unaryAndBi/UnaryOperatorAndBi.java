package chapter4.interfaceFuncional.unaryAndBi;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorAndBi {

	public static void main(String... strings) {
		// recebe um/ou mais parametros, realiza um processo e retorna o mesmo
		// tipo do parametro
		UnaryOperator<String> u = s -> s.concat(" de Castro");

		// recebe no Generics <String, String, String> ou seja <T, U, R>
		BinaryOperator<String> b = (x, y) -> x.length() + " de tamanho p/ X e p/ Y " + y.length();

		System.out.println(u.apply("Lucas"));
		System.out.println(b.apply("Lucas", " de Castro"));
	}
}
