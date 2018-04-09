package chapter5.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TryWithResources {

	public static void main(String... strings) {

	}

	public void newApproach(Path p, Path pp) {
		//Assim já fecha o recurso de leitura e escrita. Nao ha a necessidade do bloco finally com os .close()'s
		try (BufferedReader in = Files.newBufferedReader(p); BufferedWriter out = Files.newBufferedWriter(pp)) {
			
			out.write(in.readLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
