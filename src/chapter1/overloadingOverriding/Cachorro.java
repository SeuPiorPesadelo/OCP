package chapter1.overloadingOverriding;

public class Cachorro extends Canino{

	//mudar tipagem do metodo tbm pode, desde q seja uma subclasse do tipo
	@Override
	public String lateComReturn(){
		return "String";
	}
	
	//sobreescrita - modficador de acesso do mesmo nivel ou mais amplo
	//e Exception do mesmo nivel ou mais restrita, ou omitir a Exception.
	//Caso o metodo da SuperClasse nao lance Checked Exception a classe
	//filha nao pode adicionar Checked Exceptions na sobreescrita
	@Override
	public void lancaException() throws ClassNotFoundException{
		
	}

	public static void main(String [] args){
		Canino c = new Cachorro();
		System.out.println(c.lateComReturn());
		
	}
}
