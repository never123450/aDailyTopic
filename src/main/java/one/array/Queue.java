package one.array;

/**
 *
 * @description: 队列
 *
 * @author: xwy
 *
 * @create: 7:23 PM 2020/7/15
**/

public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getCapacity();
}
