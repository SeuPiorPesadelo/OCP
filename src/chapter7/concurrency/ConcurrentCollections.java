package chapter7.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollections {
	
	private static Map<String,Object> m = new HashMap<>();
	private static Map<String,Object> c = new ConcurrentHashMap<>();
	
	public static void main(String... strings) {
		m.put("L", "Lucas");
		m.put("C", "Castro");
		c.put("L", "Lucas");
		c.put("C", "Castro");
		
		for (String key : c.keySet()) {
			c.remove(key);
		}
		System.out.println("is concurrent map empty? " + c.isEmpty());
		
		
		for (String key : m.keySet()) {
			m.remove(key);//ConcurrentModificationException pq 'm' nao é devidamente atualizada depois de removido um objeto
		}
	}

}
