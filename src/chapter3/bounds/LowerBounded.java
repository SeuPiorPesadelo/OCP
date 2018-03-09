package chapter3.bounds;

import java.util.ArrayList;
import java.util.List;

public class LowerBounded {

	public static void main(String[] args){
		List<Number> l = new ArrayList<>();
		l.add(1);
		l.add(10);
		total(l);
	}

	//? significa q aceita qualquer List cujo conteúdo seja superClass de Integer
	//list mutavel
	private static void total(List<? super Integer> list) {
		list.add(2);//compila, eh mutavel
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
