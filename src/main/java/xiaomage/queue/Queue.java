package xiaomage.queue;

import xiaomage.queue.list.LinkedList;
import xiaomage.queue.list.List;

/**
 * @Description  队列
 * @author xwy
 * @date 21/8/2021 上午11:47
 * @param 
 * @param null 
 * @return 
 */
public class Queue<E> {
	private List<E> list = new LinkedList<>();
	
	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void clear() {
		list.clear();
	}

	public void enQueue(E element) {
		list.add(element);
	}

	public E deQueue() {
		return list.remove(0);
	}

	public E front() {
		return list.get(0);
	}
}
