package chapter7.concurrency.collections;

import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Sempre quando ver SkipdList pense em ordenacao
 * @author Lucas
 *
 */
public class ClassesConcurrentSkipListMapESet {

	public static void main(String... strings) {
		
		//boa pratica atribui-lo ao SortedMap
		SortedMap<String, Integer> map = new ConcurrentSkipListMap<>();
		map.putIfAbsent("Lucas", 1);
		
		//boa pratica atribui-lo ao NavigableSet
		NavigableSet<Integer> set = new ConcurrentSkipListSet<>();
		set.add(1);
	}
}
