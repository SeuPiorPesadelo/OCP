package chapter7.concurrency;

public class Threads implements Runnable {//melhor eh implementar Runnable, aproveita os recursos do ExecutorService

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Printando registro com Runnable: " + i);
		}
	}

	public static void main(String...strings){
		System.out.println("COMECOU");
		(new Thread(new Threads2())).start();
		(new Thread(new Threads())).start();
		System.out.println("TERMINOU");
	}
}

class Threads2 extends Thread {//extendo limita essa classe a nao extender outra classe e nao aproveitar o ExecutorService

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Printando registro extendendo Thread: " + i);
		}
	}
}