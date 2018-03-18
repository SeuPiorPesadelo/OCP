package chapter3.methodReferences;

import java.util.function.Predicate;

public class MetodoDeIntanciaDeUmaInstanciaEmTempoDeExecucao {
	
	public static void main(String... strings) {

		String instanciaEmQuestao = "Lucas";

		// metodo de instancia de uma instancia q surgirá em tempo de execucao
		Predicate<String> predicate = String::isEmpty;
		// equivalente em lambda
		// Predicate<String> predicate = s -> s.isEmpty();

		boolean b = predicate.test("L");// interface funcional Predicate aceita
										// 1 parametro e retorna boolean
		System.out.println(b);
	}
}
