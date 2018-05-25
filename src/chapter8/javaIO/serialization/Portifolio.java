package chapter8.javaIO.serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

class Portfolio implements Serializable {

	private static final long serialVersionUID = 5454226349386840767L;
	String accountName;
	//approach to implement a custom serializable for Bond
	transient Bond[] bonds = new Bond[] {}; // must be transient because Bond
											// class does not implement
											// Serializable

	//overwrite method writeObject() from ObjectOutputStream
	private void writeObject(ObjectOutputStream os) throws Exception {
		os.defaultWriteObject();
		os.writeInt(bonds.length);
		// write the state of bond objects
		for (int i = 0; i < bonds.length; i++) {
			os.writeObject(bonds[i].ticker);
			os.writeDouble(bonds[i].coupon);
			os.writeObject(bonds[i].maturity);
		}
	}

	//overwrite method readObject() from ObjectInputStream
	private void readObject(ObjectInputStream os) throws Exception {
		os.defaultReadObject();
		int n = os.readInt();
		this.bonds = new Bond[n];
		// read the state of bond objects.
		for (int i = 0; i < bonds.length; i++) {
			bonds[i] = new Bond();
			bonds[i].ticker = (String) os.readObject();
			bonds[i].coupon = os.readDouble();
			bonds[i].maturity = (java.util.Date) os.readObject();
		}

	}
}

class Bond {// does not implement Serializable
	String ticker = "bac";
	double coupon = 8.3;
	java.util.Date maturity = new Date();
}