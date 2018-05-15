package chapter8.javaIO.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedReaderAndWriter {

	public static void main(String... strings) {
		File source = new File("zoo.txt");
		File destination = new File("zooCopy.txt");
		
		List<String> data = readFile(source);
		writeFile(data, destination);
		
		for (String recorded : data) {
			System.out.println("registrado: " + recorded);
		}
	}

	static List<String> readFile(File source) {
		List<String> data = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
			
			String s;
			while ((s = reader.readLine()) != null) {
				data.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	static void writeFile(List<String> data, File destination) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
			
			for (String string : data) {
				writer.write(string);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
