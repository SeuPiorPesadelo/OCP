package chapter1.enums;

enum Title2 {

	DR;

	// Enum pode ter atributos de outras Classes/Enums/Interfaces e usá-los como
	// lhe convir
	private Title t;

	public static void main(String... strings) {

		System.out.println(Title2.DR.t.MRS);// usando a constante deste Enum p/
											// acessar o atributo,
		// e assim, acessar os atributos de outro Enum

		switch (Title2.DR.t) {//nas labels nao se declara 'Enum.constante', e sim a constante diretamente
		case MR ://constante do Enum, no switch, é declarada diretamente
			System.out.println("Senhor");
		case MS :
			System.out.println("Senhora");
		default:
			System.out.println("Nao achou nada");
			break;
		}
	}
}