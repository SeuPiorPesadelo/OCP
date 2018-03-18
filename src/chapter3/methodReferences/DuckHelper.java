package chapter3.methodReferences;

import chapter3.comparableAndComparator.DuckComparator;

public class DuckHelper {

	public static int comparaId(DuckComparator d1, DuckComparator d2){
		return d1.getId() - d2.getId();
	}
}
