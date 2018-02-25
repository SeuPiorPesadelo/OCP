package chapter1.nestedClasses;

/**
 * Local Inner Class
 * 
 * @author Lucas
 *
 */
public class Local {

	private int length = 5;

	// Classe Local eh a classe q existe dentro de metodos
	public Integer calculate() {
		int width = 5;
		length++;
		
		class Inner {// sem modificador de acesso e sem nada static
			public int multiply() {
				metodoDaOuterClass();// pode acessar campos/metodos da Outer
				// so usa variaveis efetivamente finais do metodo em q a classe
				// se encontra
				return length * width;
			}
		}

		Inner i = new Inner();
		return i.multiply();
	}

	public static void metodoDaOuterClass() {
		System.out.println("Class Outer1");
	}

	public static void main(String[] args) {
		Local out = new Local();
		System.out.println(out.calculate());
		int i = out.calculate();
		System.out.println(i);
	}
}
