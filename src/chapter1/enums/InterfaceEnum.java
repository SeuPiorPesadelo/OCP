package chapter1.enums;

public interface InterfaceEnum extends InterfaceTest {//interface pode extender

	default void metodoDaInterface() {
		System.out.println("Metodo da Interface");
	}
	
	//torna abstrato o metodo sobreescrito
	public void metodoImplementadoNaInterfaceTest();
}
