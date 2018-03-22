package chapter4.interfaceFuncional.Supplier;

import java.util.function.Supplier;

public class SupplierInterface {

	public static void main(String...strings) {
		
		//normalmente usado p/ criar objetos, mas podem ser usados como Comparator, por exemplo.
		Supplier<StringBuilder> s =  StringBuilder::new;
		Supplier<StringBuilder> s1 = () -> new StringBuilder();
		
		System.out.println(s1);//chapter4.interfaceFuncional.Supplier.SupplierInterface$$Lambda$2/1418481495@1218025c
		
		StringBuilder x = s1.get();
		x.append("Supplier");
		System.out.println(x);
	}
}
