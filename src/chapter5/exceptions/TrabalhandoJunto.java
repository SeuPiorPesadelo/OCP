package chapter5.exceptions;

import java.io.IOException;

public class TrabalhandoJunto implements AutoCloseable {

	private int num;

	public TrabalhandoJunto(int n) {
		num = n;
	}

	@Override
	public void close() {
		System.out.println("Fechando o " + num);
		throw new IllegalStateException("Lancada no close() do num: " + num);//constará como suprimida
	}
	
	public String read() throws IOException {
		String h = "";
		return "";
	}

	public static void main(String... strings) {
		
		//os recursos sao fechados na ordem inversa do qual foram abertos
		try (TrabalhandoJunto t1 = new TrabalhandoJunto(1); TrabalhandoJunto t2 = new TrabalhandoJunto(2)) {
			
			//será a exception principal
			throw new RuntimeException("Runtime dentro do bloco Try");
		} catch (Exception e) {
			System.out.println("Pegou exception " + e.getMessage());
			for (Throwable x : e.getSuppressed()) {
				System.out.println("Exception Suprimida: " + x);// Exception Secundaria
			}
		} finally {
			System.out.println("Executou o finally");
		}
	}
}
