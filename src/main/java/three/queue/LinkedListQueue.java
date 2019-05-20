package three.queue;

/**
 * @description: 基于链表的队列
 * @author: xwy
 * @create: 10:07 PM 2019/5/20
 **/

public class LinkedListQueue {

    //队列的队首和队尾
    private Node head = null;
    private Node tail = null;

    //入队
    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    //出队
    public String dequeue() {
        if (head == null) return null;

        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    /**
     * @description: 定义链表
     * @author: xwy
     * @create: 10:10 PM 2019/5/20
     **/

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}