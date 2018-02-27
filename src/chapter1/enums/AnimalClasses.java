package chapter1.enums;

public enum AnimalClasses implements InterfaceEnum {//Enum pode implementar mas NAO extender

	C, CC, CCC;

	public static void main(String[] args) {
		AnimalClasses.C.metodoDaInterface();
		System.out.println(AnimalClasses.valueOf("CCC").name());
		System.out.println(AnimalClasses.valueOf("CC").ordinal());
	}

	@Override
	public void metodoImplementadoNaInterfaceTest() {
		// forca a implementacao do metodo sobreescrito abstrato
	}
}