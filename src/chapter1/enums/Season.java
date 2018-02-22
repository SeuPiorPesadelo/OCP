package chapter1.enums;

public enum Season {
	// variaveis de Enum sao estaticas e finais
	VERAO("alta") {
		
		@Override
		public void horario() {
			System.out.println("Horario extendido");
		}
		
	},
	OUTONO("media"), INVERNO("baixa") {
		
		@Override
		public void horario() {
			System.out.println("Horario reduzido");
		}
		
	},
	PRIMAVERA("media");

	private String expectativa;

	// construtor de Enum sempre privado
	private Season(String n) {
		expectativa = n;
		System.out.println("Construtor de Enum chamado");
	}

	// public abstract void horario(); se for abstrato, todos os metodos tem q implementar
	public void horario() {
		System.out.println("Horario Padrao");
	}

	public static void main(String[] args) {
		for (Season s : Season.values()) {
			System.out.println(s);
			System.out.println(s.name() + ", " + s.ordinal() + ", expectativa: " + s.expectativa);
		}

		// Season.valueOf("verao"); IllegalArgumentException

		// Nao instanciou novamete. Uma vez jah instanciado, nao usa o
		// construtor de novo
		System.out.println(Season.OUTONO);
		
		Season.VERAO.horario();
	}
}
