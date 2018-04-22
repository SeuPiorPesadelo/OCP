package chapter6.exceptions;

import java.io.IOException;
import java.sql.SQLException;

public class MuiltiCatch {

	public static void main(String... strings) {

		try {
			String f = "a";
			int y = Integer.parseInt(f);
		} catch (NumberFormatException | ArithmeticException e) {//sintaxe correta
			e.printStackTrace();
		}
	}
}
