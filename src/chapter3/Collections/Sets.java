package chapter3.Collections;

import java.util.*;

public class Sets {

	public static void main(String... args) {
		//Set nao aceita repetidos
		metodoHashSet();
		
		//TreeSet adiciona já ordenando
		metodoTreeSet();
		
		//TreeSet tem a Interface NavigableSet 
		NavigableSet<Integer> tree = new TreeSet<>();
		for (int i = 1; i <= 10; i++) tree.add(i);
		System.out.println("lower " + tree.lower(5)); //menor q 5
		System.out.println("floor " + tree.floor(5)); //menor ou igual
		System.out.println("ceiling " + tree.ceiling(10)); //numeros mais baixo maior ou igual a 10
		System.out.println("higher " + tree.higher(10)); //numeros mais baixo maior q 10
	}

	private static void metodoHashSet() {
		Set<Integer> set = new HashSet<>();
		set.add(0);
		set.add(2);
		set.add(3);
		set.add(1);
		set.forEach(s -> System.out.print(s));
		System.out.println();
	}

	private static void metodoTreeSet() {
		Set<Integer> tree = new TreeSet<>();
		tree.add(8);
		tree.add(6);
		tree.add(7);
		tree.add(5);
		tree.forEach(t -> System.out.print(t));
		System.out.println();
	}

}
