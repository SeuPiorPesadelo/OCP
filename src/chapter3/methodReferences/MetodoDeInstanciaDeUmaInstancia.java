package chapter3.methodReferences;

import java.util.function.Predicate;

public class MetodoDeInstanciaDeUmaInstancia {
	
	public static void main(String... strings) {
		
		String instanciaEmQuestao = "Lucas";
		
		//metodo de instancia de uma instancia
		Predicate<String> predicate = instanciaEmQuestao::startsWith;
		// equivalente em lambda
		// Predicate<String> predicate =  s -> instanciaEmQuestao.startsWith(s);

		boolean b = predicate.test("L");//interface funcional Predicate aceita 1 parametro e retorna boolean
		System.out.println(b);
	}
}
