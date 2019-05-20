package three.LRU;

import java.util.Scanner;

/**
 * @description: 基于单链表的LRU算法
 * @author: xwy
 * @create: 3:10 PM 2019/5/16
 **/

public class LRUBaseLinkedList<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 聊表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.length = DEFAULT_CAPACITY;
        this.capacity = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.length = capacity;
        this.capacity = 0;
    }

    public void add(T data) {
        //查找这个元素是否有前一个节点
        SNode preNode = findPreNode(data);

        //链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null) {
            deleteElement(preNode);
            insertElementAtBegin(data);
        } else {
            if (length >= this.capacity) {
                //删除尾节点
                deleteElementAtEnd();
            }
            insertElementAtBegin(data);
        }

    }

    /**
     * 删除preNode元素的下一个节点
     *
     * @param preNode
     */
    private void deleteElement(SNode preNode) {
        preNode.setNext(preNode.getNext().getNext());
        length--;
    }

    /**
     * 删除最后一个元素
     */
    private void deleteElementAtEnd() {
        SNode head = headNode;

        //链表为空直接返回
        if (head.getNext() == null) {
            return;
        }

        while (head.getNext() != null) {
            head = head.getNext();
        }

        head.setNext(null);
        length--;

    }

    private void pringAll() {
        SNode node = headNode.getNext();
        System.out.print("head->");
        while (node != null) {
            System.out.print(node.getElement() + "->");
            node = node.getNext();
        }
        System.out.print("tail");
        System.out.println();
    }

    /**
     * 链表头部插入元素
     *
     * @param data
     */
    private void insertElementAtBegin(T data) {
        headNode.setNext(new SNode(data, headNode.getNext()));

        length++;
    }

    /**
     * 获取元素的前一个节点
     *
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }


    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList linkedList = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.pringAll();

        linkedList.add(1);
        linkedList.pringAll();
    }
}