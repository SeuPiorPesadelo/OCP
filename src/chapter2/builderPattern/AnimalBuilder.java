package chapter2.builderPattern;

import java.util.Arrays;
import java.util.List;

import chapter2.immutableClass.Animal;

//classe usada parafacilitar a montagem do objeto de outra classe. Muito usado no TDD
public class AnimalBuilder {

	private String species;
	private int age;
	private List<String> comidasFavoritas;

	public AnimalBuilder setSpecies(String s) {
		this.species = s;
		return this;
	}

	public AnimalBuilder setAge(int a) {
		age = a;
		return this;
	}

	public AnimalBuilder setComidasFavoritas(List<String> l) {
		comidasFavoritas = l;
		return this;
	}

	public Animal build() {
		return new Animal(species, age, comidasFavoritas);
	}

	// na pratica
	public static void main(String... args) {
		System.out.println(
				new AnimalBuilder().setAge(10).setSpecies("Cao").setComidasFavoritas(Arrays.asList("Carne")).build());
	}

}
