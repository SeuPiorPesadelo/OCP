package chapter8.javaIO.streams;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//it is a class that writes on the file
public class PrintWriterAndPrintStream {

	public static void main(String... args) throws FileNotFoundException {
		File source = new File("zoo.txt");
		
		try(PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(source)))){
			p.print("assssssssssssd");
			p.println("ddd");
			p.write(97);//allows int, but writes a character
			p.println('L');
			p.format("dd/mm/yyyy", new Date());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
