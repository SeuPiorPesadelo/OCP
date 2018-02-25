package chapter1.nestedClasses;

/**
 * Member Inner Class
 * 
 * @author Lucas
 *
 */
public class Member {

	private String variable = "Oi";

	//classe membro
	protected class Inner {
		private int repete = 3;

		public void print() {
			for (int i = 0; i < repete; i++) {
				//pode usar variaveis da class externa
				System.out.println(variable);
			}
		}
	}
	
	public void callInner(){
		Inner inner = new Inner();
		inner.print();
	}
	
	public static void main(String[] args){
		new Member().callInner();
		new Member().new Inner().print();
	}
}
