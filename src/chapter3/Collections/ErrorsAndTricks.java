package chapter3.Collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ErrorsAndTricks {

	public static void main(String... args) {
		criarArayListSemGenerics();
		System.out.println();
		comportamentoArrayDeque();
	}

	private static void comportamentoArrayDeque() {
		// sem o uso de Generics significa q aceita qualquer coisa
		ArrayDeque<String> list = new ArrayDeque<>();
		list.push("Lucas");
		list.push(" OCP ");
		list.push(" Oracle ");
		list.pop();//retorna e remove o primeiro elemento da list
		System.out.println(list.peek());//soh mostra
		
		while (list.peek() != null) {// como estah removendo dentro do laço, o peek() sempre sera diferente
			System.out.println(list.pop());
		}
	}

	private static void criarArayListSemGenerics() {
		// sem o uso de Generics significa q aceita qualquer coisa
		List list = new ArrayList();
		list.add("Lucas");
		list.add(1);
		list.add(3.14D);

		// for (String s : list) {//aqui dah erro de compilacao, afinal eh uma
		// list de Objects
		for (Object o : list) {
			System.out.println(o);
		}
	}
}
