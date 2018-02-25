package chapter1.nestedClasses;

public class Static {

	private static int custo = 1;

	public void metodoDaClasseExterna() {
		System.out.println("metodoDaClasseExterna");
	}

	static public class Estatica {
		private int preco = 99;

		public static void staticMethod() {
			System.out.println("metodo dentro da classe estatica interna");
		}
	}

	public void main(String args[]) {
		System.out.println(new Estatica().preco);
	}
}
