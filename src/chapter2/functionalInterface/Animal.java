package chapter2.functionalInterface;

public class Animal {

	private String especie;
	private boolean podePular;
	private boolean podeNadar;
	
	public Animal(String especie, boolean podePular, boolean podeNadar) {
		this.especie = especie;
		this.podePular = podePular;
		this.podeNadar = podeNadar;
	}
	
	public boolean podePular(){return podePular;}
	public boolean podeNadar(){return podeNadar;}
	public String toString(){return especie;}
}
