package chapter8.javaIO.streams;

import java.io.Console;

public class ConsoleClass {

	public static void main(String...strings){
		Console c = System.console();
		System.out.println(c != null);
		//prevents enviroments where text interactions are not supported
		if(c != null){
			System.out.println("Escreve algo");
			String userInput = c.readLine();
			c.writer().println("tu escrevestes: " + userInput);
		}
	}
}
