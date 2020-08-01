package xiaomage.set;


import xiaomage.hash.LinkedHashMap;
import xiaomage.hash.Map;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 5:18 PM 2020/7/31
**/

public class LinkedHashSet<E> implements Set<E> {
	private LinkedHashMap<E, Object> map = new LinkedHashMap<>();

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean contains(E element) {
		return map.containsKey(element);
	}

	@Override
	public void add(E element) {
		map.put(element, null);
	}

	@Override
	public void remove(E element) {
		map.remove(element);
	}

	@Override
	public void traversal(Visitor<E> visitor) {
		map.traversal(new Map.Visitor<E, Object>() {
			public boolean visit(E key, Object value) {
				return visitor.visit(key);
			}
		});
	}

}
