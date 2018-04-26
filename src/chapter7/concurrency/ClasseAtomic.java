package chapter7.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class ClasseAtomic {

	private static AtomicInteger i;
	
	public static void main(String... strings) {
		i = new AtomicInteger(1);
		System.out.println(i.getAndSet(2));
		System.out.println(i);
	}
}
