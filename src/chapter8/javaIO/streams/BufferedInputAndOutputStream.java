package chapter8.javaIO.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputAndOutputStream {

	public static void main(String... strings) {
		File source = new File("zoo.txt");
		File destination = new File("zooCopy.txt");
		
		copy(source, destination);
		System.out.println("Copied");
	}

	static void copy(File source, File destination) {
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
			
			byte[] buffer = new byte[1014];//buffer 1024 bytes
			int lengthRead;
			while ((lengthRead = in.read(buffer)) > 0) {// 0 if the end of the file is reached
				out.write(buffer, 0, lengthRead);// it writes bytes[] in destination
				out.flush();//send to file 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
