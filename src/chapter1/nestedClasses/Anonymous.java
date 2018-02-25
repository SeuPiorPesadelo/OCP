package chapter1.nestedClasses;

public class Anonymous {

	// Member Class. Pode ser tbm interface
	abstract class VenderSomenteHoje {
		abstract int desconto();
	}

	public int venda(int preco) {
		// Anonymous Class
		VenderSomenteHoje v = new VenderSomenteHoje() {

			@Override
			int desconto() {
				return 2;
			}
		};// <- obrigatorio ;
		return preco - v.desconto();
	}
	
	interface DeuALoucaNasCasasBahia {
		int desconto();
	}
	
	public int vendaBahia(){
		return descontao(100, new DeuALoucaNasCasasBahia() {
			
			@Override
			public int desconto() {
				return 99;
			}
		});
	}
	
	public int descontao(int precoBase, DeuALoucaNasCasasBahia casasBahia){
		return precoBase - casasBahia.desconto();
	}
}
