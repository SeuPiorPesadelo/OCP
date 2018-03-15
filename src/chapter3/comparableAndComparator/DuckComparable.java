package chapter3.comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuckComparable implements Comparable<DuckComparable>{
	
	private int id;
	private String name;
	
	public DuckComparable(String name){
		this.name = name;
	}

	public DuckComparable(int id, String name) {
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
	public int compareTo(DuckComparable d) {
		return name.compareTo(d.name); //chama o compareTo() da String. Ordem CRESCENTE
		//return d.name.compareTo(name);//Ordem DECRESCENTE
	}

	public static void main(String...args){
		List<DuckComparable> ds = new ArrayList<>();
		ds.add(new DuckComparable("Donald"));
		ds.add(new DuckComparable("Patolino"));
		Collections.sort(ds);
		ds.forEach(d -> System.out.println(d));
	}
}
