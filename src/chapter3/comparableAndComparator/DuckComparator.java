package chapter3.comparableAndComparator;

import java.util.Comparator;

//Comparator implementado diretamente na classe juntamente com Comparable
public class DuckComparator implements Comparator<DuckComparator>, Comparable<DuckComparator> {

	private int id;
	private String name;

	public DuckComparator(String name) {
		this.name = name;
	}

	public DuckComparator(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pato " + name + ", id " + id;
	}

	@Override
	public int compare(DuckComparator d1, DuckComparator d2) {
		// ordena alfabeticamente
		int x = d1.getName().compareTo(d2.getName());
		if (x != 0) {
			return x;
		} else {// senao, ordena por Id
			return d1.getId() - d2.getId();
		}
	}

	@Override
	public int compareTo(DuckComparator d) {
		return this.name.compareTo(d.getName());
	}

}
