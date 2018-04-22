package chapter6.exceptions;

public class SuppressedException {

	public static void main(String... strings) {
		try (ClasseComClosable c = new ClasseComClosable()) {
			throw new IllegalStateException("Estorou no metodo main()");// Exception Primaria
		} catch (IllegalStateException e) {
			System.out.println("Pegou: " + e.getMessage());
			for (Throwable x : e.getSuppressed()) {
				System.out.println("Exception Suprimida: " + x);// Exception Secundaria
			}
		}

		System.out.println();
		
//		try (ClasseComClosable c = new ClasseComClosable()) {
//			throw new RuntimeException("Deu uma RuntimeException");// primaria eh Runtime, apesar de
//																	// nao estar no bloco catch
//		} catch (IllegalStateException e) {
//			System.out.println("#############################");
//			System.out.println("Pegou RuntimeException? " + e.getMessage());//nem executa o bloco catch
//		}
		
		System.out.println();
		
		try (ClasseComClosable c = new ClasseComClosable()) {
			throw new IllegalStateException("Estorou no metodo main()");// Exception Primaria
		} finally {
			throw new RuntimeException("Deu uma RuntimeException no bloco finally");//exception em finally tem a preferencia
																					//logo, ela sobreescreve a exception pirmaria e a suprimida
		}
	}

}

class ClasseComClosable implements AutoCloseable {

	@Override
	public void close() throws IllegalStateException {
		throw new IllegalStateException("Estorou exception em ClasseComClosable");
	}

}