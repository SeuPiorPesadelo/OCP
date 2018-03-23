package chapter4.interfaceFuncional.predicateAndBi;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateAndBi {

	public static void main(String...strings) {
		
		//normalmente usado p/ filtrar ou achar uma combina��o
		Predicate<String> s1 =  String::isEmpty;//aqui eh um metodo de referencia em uma instancia espec�fica,
		Predicate<String> s2 = (a) -> a.isEmpty();//ou seja, o isEmprty() funcionar� em cima de uma �nica vari�vel
		
		boolean x = s1.test(" ".trim());// <- uma unica vari�vel aqui
		System.out.println("metodo de referencia em uma instancia espec�fica: "+x);
		
		
		BiPredicate<String, String> p1 = String::startsWith;//usa metodo de referencia de instancia que ser� passada em
		BiPredicate<String, String> p2 = (string1, string2) -> string1.startsWith(string2);//tempo de execucao
		System.out.println("metodo de referencia em uma instancia passada em tempo de execucao: "+p1.test("Lucas", "L"));
		System.out.println("metodo de referencia em uma instancia passada em tempo de execucao: "+p2.test("Asd", "zxc"));
	}
}
