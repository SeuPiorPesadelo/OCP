package chapter2.functionalInterface;

//tem q ter apenas um metodo abstrato
//sao usadas em lambdas
@FunctionalInterface
public interface ChecarCaracteristica<T> {//utilizado Generics, assim qualquer classe pode usar

	boolean test(T t);
}
