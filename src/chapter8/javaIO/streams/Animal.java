package chapter8.javaIO.streams;

import java.io.Serializable;

public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private char type;

	public Animal(String name, int age, char type) {
		this.name = name;
		this.age = age;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
	}

}
