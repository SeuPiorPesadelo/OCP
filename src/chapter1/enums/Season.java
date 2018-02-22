package chapter1.enums;

public enum Season {
	//variaveis de Enum sao estaticas e finais
	VERAO, OUTONO, INVERNO,PRIMAVERA;
	
	public static void main(String []args){
		for (Season s : Season.values()) {
			System.out.println(s);
			System.out.println(s.name() + ", " + s.ordinal());
		}
		
//		Season.valueOf("verao"); IllegalArgumentException
	}
}
