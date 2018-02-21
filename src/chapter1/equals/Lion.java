package chapter1.equals;

public class Lion {

	private int idNumber, age;
	private String name;

	public Lion(int idNumber, int age, String name) {
		this.idNumber = idNumber;
		this.age = age;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Lion)) {
			return false;
		}
		Lion another = (Lion) o;
		return this.idNumber == another.idNumber;
	}

	public static void main(String[] args) {
		String s1 = new String("asd");
		String s2 = new String("asd");
		// a classe String sobreescreve equals() de Object
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);

		StringBuilder sb1 = new StringBuilder("StringBuilder");
		StringBuilder sb2 = new StringBuilder("StringBuilder");
		// StringBuilder nao sobrescreve equals(), soh usa o
		// equals direto de Object q avalia apenas se as variaveis apontam p/ o
		// mesmo objeto
		System.out.println(sb1.equals(sb2));

		Lion l1 = new Lion(1, 2, "as");
		Lion l2 = new Lion(1, 3, "ewq");
		System.out.println("Leoes iguais? " + l1.equals(l2));
	}
}
