package chapter8.javaIO.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Boo implements Serializable {

	private static final long serialVersionUID = -5975860509545932894L;
	transient int ti = 10;
	static int si = 20;
	String name;
	static boolean x;
	
	public Boo(){
		System.out.println("Chamou Construtor");
	}
	
	static {
		x = true;
		System.out.println("Chamou bloco de static");
		si = 23;
	}
	
	{
		name = "Lucas";
		System.out.println("Chamou bloco de instancia");
		ti = 12;
	}
	
	@Override
	public String toString() {
		return "Boo [ti=" + ti + ", si=" + si + ", name=" + name + ", x=" + x + "]";
	}
}

public class TestClass {
	
	public static void main(String[] args) throws Exception {
		Boo boo = new Boo();
		boo.si++;
//		boo.name = "Ze Colmeia";
		System.out.println("ti: " + boo.ti + ", si: " + boo.si);

		try (FileOutputStream fos = new FileOutputStream("boo.ser");
				ObjectOutputStream os = new ObjectOutputStream(fos)) {
			os.writeObject(boo);
		}

		try (FileInputStream fis = new FileInputStream("boo.ser");
				ObjectInputStream is = new ObjectInputStream(fis)) {
			boo = (Boo) is.readObject();
		}
		System.out.println(boo);
	}
}