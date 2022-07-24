package leecode.linkedList;


import java.util.HashMap;
import java.util.Map;

/**
 * @description: 实现LRU算法（最近最少使用）(哈希表+双向链表)
 * @author: xwy
 * @create: 1:28 PM 2020/4/11   2020年10月03日09:07:52
 **/

public class Solution146 {

    private Map<Integer, Node> map;
    private int capacity;
    // 虚拟头结点
    private Node first;
    // 虚拟尾节点
    private Node last;

    public Solution146(int capacity) {
        map = new HashMap(capacity);
        this.capacity = capacity;
        first = new Node();
        last = new Node();
        first.next = last;
        last.prev = first;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        removeNode(node);
        addAfterFirst(node);

        return node.value;
    }

    /**
     * 将 node 结点插入到first 结点的后面
     *
     * @param node
     */
    private void addAfterFirst(Node node) {
        // node 与 first.next
        node.next = first.next;
        first.next.prev = node;

        // node 与 first
        first.next = node;
        node.prev = first;

    }

    /**
     * 将 node 节点从双向链表中删除
     *
     * @param node
     */
    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            addAfterFirst(node);
        } else {
            if (map.size() == capacity) {
                // 淘汰最近最少使用的 key-value
                removeNode(map.remove(last.prev.key));
            }
            map.put(key, node = new Node(key, value));
            addAfterFirst(node);
        }
    }

    private static class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    public static void main(String[] args) {
        Map<Integer,Object> map = new HashMap<>();
        map.put(1,'a');
        map.put(2,'b');
        map.put(3,'c');
        System.out.println(map.keySet().iterator().next());
        Object remove = map.remove(2);
        System.out.println(remove);
        map.put(2,'b');
        System.out.println(map.keySet().iterator().next());

    }
}