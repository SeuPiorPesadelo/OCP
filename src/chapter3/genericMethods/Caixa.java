package chapter3.genericMethods;

public class Caixa {

	// generic method printArray
	//<T> eh Tipo de Parametro Formal
	//T[] eh Tipo de Retorno
	//T[] inputArray eh Tipo de Parametros
	public static <T> T[] printArray(T[] inputArray) {
		// Display array elements
		for (T element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
		return inputArray;
	}

	public static void main(String args[]) {
		// Create arrays of Integer, Double and Character
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("Array integerArray contains:");
		printArray(intArray); // pass an Integer array

		System.out.println("\nArray doubleArray contains:");
		printArray(doubleArray); // pass a Double array

		System.out.println("\nArray characterArray contains:");
		printArray(charArray); // pass a Character array
		
		String[] stringArray = {"Lucas", "L"};
		Caixa.<String>printArray(stringArray);//outra forma de chamar
	}
}
