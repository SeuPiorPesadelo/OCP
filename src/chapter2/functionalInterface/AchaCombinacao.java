package chapter2.functionalInterface;

import java.util.function.Predicate;

public class AchaCombinacao {

	// cria-se um metodo como base p/ ser executado
	private static void print(Animal a, Predicate<Animal> c) {//utilizado Generics
		if (c.test(a)) {
			System.out.println(a);
		}
	}

	public static void main(String... ars) {

		// usa-se esse metodo base passando por lambda a expressao
		print(new Animal("peixe", false, true), a -> a.podeNadar());// lambda
		print(new Animal("cao", true, true), (a) -> {
			System.out.println("Pode colocar uma implemantacao qualquer aqui");
			return a.podePular();
		});// lambda NERDS
	}
}
