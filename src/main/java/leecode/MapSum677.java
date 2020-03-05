package leecode;

import java.util.TreeMap;

//  https://leetcode.com/problems/map-sum-pairs/
public class MapSum677 {

    private class Node {

        public int value;
        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum677() {

        root = new Node();
    }

    public void insert(String key, int val) {

        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return 0;
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    private int sum(Node node) {

        int res = node.value;
        for (char c : node.next.keySet())
            res += sum(node.next.get(c));
        return res;
    }


    public static void main(String[] args) {
        MapSum677 obj = new MapSum677();
        obj.insert("ab", 1);
        obj.insert("abb",2);
        int param_2 = obj.sum("ab");
        System.out.println(param_2);
    }
}
