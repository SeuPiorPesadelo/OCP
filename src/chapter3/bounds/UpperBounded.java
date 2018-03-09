package chapter3.bounds;

import java.util.ArrayList;
import java.util.List;

public class UpperBounded {

	public static void main(String[] args){
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(1);
		long lo = total(l);
		System.out.println(lo);
	}

	//? significa q aceita qualquer List cujo conteúdo extenda Number
	//Nao eh mutavel
	private static long total(List<? extends Number> list) {
		long count = 0;
		//list.add(1); N compila, eh Imutavel
		for (Number number : list) {
			count += number.longValue();
		}
		return count;
	}
}
