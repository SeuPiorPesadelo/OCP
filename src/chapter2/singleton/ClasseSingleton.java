package chapter2.singleton;

public class ClasseSingleton {

	private int quantidade;
	
	//construtor privado
	private ClasseSingleton(){}
	
	//instancia static e final
//	private static final ClasseSingleton instance = new ClasseSingleton();
	private static final ClasseSingleton instance;
	
	static {//outra opcao de inicializacao de Singleton
		instance = new ClasseSingleton();
	}
	
	//metodo q devolve a instancia
	public static ClasseSingleton getInstance(){
		return instance;
	}
	
	//synchronized em todos os metodos de acao e de gets
	public synchronized void addQtd(int q){
		quantidade += q;
	}
	
	public synchronized boolean remove(int q){
		if(quantidade < q){
			return false;
		} else {
			return true;
		}
	}
	
	public synchronized int getQuantidade(){
		return quantidade;
	}
}
