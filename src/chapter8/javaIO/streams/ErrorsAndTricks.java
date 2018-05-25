package chapter8.javaIO.streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ErrorsAndTricks {

	public static void main(String... strings) throws FileNotFoundException {
		streamEmbrulhada2vezes();
		skipping();
	}

	private static void skipping() {
		try (FileInputStream fis = new FileInputStream("test.txt");
				InputStreamReader isr = new InputStreamReader(fis)) {
			while (isr.ready()) {
				isr.skip(1);// skipped 1 , 3 , 5 and 7
				int i = isr.read();
				char c = (char) i;
				System.out.println("Character: " + c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void streamEmbrulhada2vezes() throws FileNotFoundException {
		InputStream is = new BufferedInputStream(new FileInputStream("zoo.txt"));
		InputStream embrulhado2vezes = new BufferedInputStream(is);
		// linha abaixo é equivalente a de cima. Pode ter n vezes instacias
		// wrapped da mesma classe
		InputStream wrappedTwice = new BufferedInputStream(new BufferedInputStream(new FileInputStream("zoo.txt")));
	}

	//we can put a CheckedException in a method declaration but not in a try/catch
	public void usePrintWriter(PrintWriter pw) throws IOException {
		boolean bval = true;
		pw.print(bval);
	}
}
