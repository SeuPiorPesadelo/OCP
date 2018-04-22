package chapter7.concurrency;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class ClasseCallable {

	public static void main(String... strings) {

		AmbiguousLambda.cuidadosComCallableESupplier();
		
	}
}

class AmbiguousLambda {

	public static void useCallable(Callable<Integer> c) {
	}

	public static void useSupplier(Supplier<Integer> c) {
	}

	public static void use(Callable<Integer> c) {
	}// Callale declara, no metodo .call() throws com throws java.lang.Exception

	public static void use(Supplier<Integer> c) {
	}// Supplier nao declara/trata nenhuma

	static void cuidadosComCallableESupplier() {
		AmbiguousLambda.useCallable(() -> {
			throw new IOException();
		});

		// AmbiguousLambda.useSupplier(() -> {
		// throw new IOException();//Nao compila pq Supplier nao declara, no
		// metodo .get(), Exception alguma
		// });

		// AmbiguousLambda.use(() -> {//Nao compila. Ambiguidade, poder
		// Callable<Integer> ou Supplier<Integer>
		// return 1;
		// });

		AmbiguousLambda.use((Supplier<Integer>) () -> {// Agora compila pq foi
														// feito um cast p/
														// Supplier<Integer>
			return 1;
		});
	}
}