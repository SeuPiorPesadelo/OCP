package chapter3.bounds;

import java.util.ArrayList;
import java.util.List;

public class Unbounded {

	public static void main(String[] args){
		List<String> a = new ArrayList<>();
		a.add("Lucas");
		printList(a);
//		printList1(a); erro de compilacao
	}

	//? significa q aceita qualquer tipagem, mas desde q seja List
	private static void printList(List<?> list) {
		for (Object x : list) {
			System.out.println(x);
		}
	}
	
	private static void printList1(List<Object> list) {
		for (Object x : list) {
			System.out.println(x);
		}
	}
}
