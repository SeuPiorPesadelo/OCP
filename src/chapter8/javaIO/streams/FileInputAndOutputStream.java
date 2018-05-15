package chapter8.javaIO.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputAndOutputStream {

	public static void main(String... strings) {
		File source = new File("zoo.txt");
		File destination = new File("zooCopy.txt");
		
		copy(source, destination);
		System.out.println("Copied");
	}

	static void copy(File source, File destination) {
		try (FileInputStream in = new FileInputStream(source);
				FileOutputStream out = new FileOutputStream(destination)) {
			int bytes;
			while ((bytes = in.read()) != -1) {// -1 if the end of the file is reached
				out.write(bytes);// it writes bytes in destination
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
