package chapter2.immutableClass;

import java.util.List;

//Classe Imutavel
public final class Animal {

	//variaveis de instacia privadas e finais
	private final String nome;
	private final int idade;
	private List<String> comidasFavoritas;
	
	//usa o construtor p/ iniciar as variaveis
	public Animal(String nome, int idade, List<String> comidasFavoritas) {
		super();
		this.nome = nome;
		this.idade = idade;
		if(comidasFavoritas == null){
			throw new RuntimeException("Deve ter comidas favoritas");
		}
		this.comidasFavoritas = comidasFavoritas;
	}
	
	//Nao possui metodos Sets
	//Nao permite q variaveis de instancia mutaveis sejam modificadas
	public int qtdDeComidasFavoritas(){
		return comidasFavoritas.size();
	}
	
	public String getComidaFavorita(int i){
		return comidasFavoritas.get(i);
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	@Override
	public String toString() {
		return "Animal [nome=" + nome + ", idade=" + idade + ", comidasFavoritas=" + comidasFavoritas + "]";
	}

}
