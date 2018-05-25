package chapter8.javaIO.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputAndOutputStream {

	public static void main(String... strings) {
		List<Animal> list = new ArrayList<>();
		list.add(new Animal("Lion", 4, 'M'));
		list.add(new Animal("Turtle", 40, 'R'));

		File dataFile = new File("animal.data");

		createAnimalsFile(list, dataFile);
		System.out.println(getAnimals(dataFile));
	}

	public static List<Animal> getAnimals(File dataFile) {
		List<Animal> list = new ArrayList<>();

		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			while (true) {
				Object o = in.readObject();
				if (o instanceof Animal) {
					list.add((Animal) o);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void createAnimalsFile(List<Animal> animals, File dataFile) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			for (Animal a : animals) {
				out.writeObject(a);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
