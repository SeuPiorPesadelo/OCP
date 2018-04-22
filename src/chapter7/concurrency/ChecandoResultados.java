package chapter7.concurrency;

public class ChecandoResultados {

	private static int count = 0;

	public static void main(String... strings) {
		new Thread(() -> {
			for (int i = 0; i < 1500; i++) {
				count++;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		while (count < 1500) {
			System.out.println("Nao chegou a 1500 ainda");
		}
		System.out.println("Chegou!!! " + count);
	}
}
