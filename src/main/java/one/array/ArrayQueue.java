package one.array;

/**
 *
 * @description: 基于数组实现的队列
 *
 * @author: xwy
 *
 * @create: 3:53 PM 2020/7/16
**/

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayQueue(){
        array = new Array<E>();
    }

    public int getSize(){
        return array.getSize();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    public void enqueue(E e){
        array.addLast(e);
    }

    public E dequeue(){
        return array.removeFirst();
    }

    public E getFront(){
        return array.getFirst();
    }

    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        for(int i = 0 ; i < 11 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}