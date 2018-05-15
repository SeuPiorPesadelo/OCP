package chapter8.javaIO.basicMethods;

import java.io.File;

public class ReadFileInformation {

	public static void main(String... strings) {
		String separator = System.getProperty("file.separator");
		separator = File.separator; // same result as the top line

		File file = new File("C:" + separator + "Users" + separator + "Lucas" + separator + "workspace" + separator
				+ "OCP" + separator + "zoo.txt");

		boolean fileExists = file.exists();
		
		if (fileExists) {
			System.out.println("Absolut path: " + file.getAbsolutePath());
			System.out.println("Parent path: " + file.getParent());
			System.out.println("Is directory: " + file.isDirectory());
			
			if (file.isFile()) {
				System.out.println("Length: " + file.length());
				System.out.println("Last Modified: " + file.lastModified());
			} else {
				for (File subFile : file.listFiles()) {
					System.out.println("\t" + subFile.getName());
				}
			}
		}
	}
}
