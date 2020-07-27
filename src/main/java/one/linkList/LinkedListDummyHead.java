package one.linkList;

/**
 *
 * @description: 基于LinkedList实现的栈
 *
 * @author: xwy
 *
 * @create: 4:35 PM 2020/7/15
**/

public class LinkedListDummyHead<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedListDummyHead() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize() {
        return size;
    }

    //返回链表中是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表头添加新的元素e
    public void addFrist(E e) {
        add(0, e);
    }

    //在链表中间添加元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add faild. illegal idnex.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;

    }

    //在链表末位添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }


    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add faild. illegal idnex.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获取链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    //修改链表的第index个位置的元素值为e
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add faild. illegal idnex.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
        }
        return false;
    }


    //删除元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    //删除链表中的第一个远
    public E removeFirst() {
        return remove(0);
    }

    //删除元素中的最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NULL");
        return res.toString();
    }
}