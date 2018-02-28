package chapter2.functionalInterface;

//tem q ter apenas um metodo abstrato
//sao usadas em lambdas
@FunctionalInterface
public interface ChecarCaracteristica {

	boolean test(Animal a);
}
