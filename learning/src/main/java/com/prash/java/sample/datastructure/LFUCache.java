/**
 * 
 */
package com.prash.java.sample.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Prashanth_Meka
 * @param <V>
 * @param <K>
 *
 */
public class LFUCache<K, V> {
	
	private int capacity;
	
	private Map<K, ValueDecorator> cache;
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<K, ValueDecorator>();
	}
	
	public V get(K k)	{
		ValueDecorator vd = cache.get(k);
		V v=null;
		if(vd != null)	{
			vd.inc();
			v = vd.value();
		}
		return v;
	}
	
	public void set(K k, V v)	{
		if(capacity == cache.size())	{
			cache.remove(getLfuKey());
		}
		ValueDecorator vd = new ValueDecorator(v);
		cache.put(k, vd);
	}
	
	private K getLfuKey()	{
		Map.Entry<K, ValueDecorator> entry = cache.entrySet().stream().sorted((e1,e2) -> {
			return (e1.getValue().counter() - e2.getValue().counter());
		}).findFirst().get();
		return entry.getKey();
	}
	
	public void printCache()	{
		System.out.println(cache);
	}
	
	class ValueDecorator	{
		private int counter = 0;
		private V v;
		public ValueDecorator(V v) {
			this.v = v;	
		}
		public void inc()	{
			counter++;
		}
		public int counter()	{
			return counter;
		}
		public V value()	{
			return v;
		}
	}		

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LFUCache<Integer, Integer> cache = new LFUCache<>(3);

		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.get(3);
		cache.get(1);
		cache.set(4, 4);
		cache.get(4);
		cache.set(5, 5);
		cache.printCache();
		
	}

}
 