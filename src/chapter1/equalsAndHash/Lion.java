package chapter1.equalsAndHash;

public class Lion {

	private int idNumber, age;
	private String name;

	public Lion(int idNumber, int age, String name) {
		this.idNumber = idNumber;
		this.age = age;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idNumber;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lion other = (Lion) obj;
		if (idNumber != other.idNumber)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
		Lion l2 = new Lion(1, 3, "as");
		System.out.println("Leoes iguais? " + l1.equals(l2));
		System.out.println("Mesmo Hash? " + (l1.hashCode() == l2.hashCode()));
		
	}
}
