package xiaomage.hash;

/**
 * @Description
 * @author xwy
 * @date 17/9/2021 下午8:06
 * @param
 * @return
 */
public interface Map<K, V> {
	int size();
	boolean isEmpty();
	void clear();
	V put(K key, V value);
	V get(K key);
	V remove(K key);
	boolean containsKey(K key);
	boolean containsValue(V value);
	void traversal(Visitor<K, V> visitor);
	
	public static abstract class Visitor<K, V> {
		boolean stop;
		public abstract boolean visit(K key, V value);
	}
}
