package two.lcs.josephus;

/**
 * @description:
 * @author: xwy
 * @create: 10:48 PM 2020/7/8
 **/

public class Josephus {
    public static int N = 20;
    public static int M = 5;//


    class Node {
        int val;//
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void killNode() {
        Node header = new Node(1);//第一个节点
        Node x = header;//目前被点到的人
        for (int i = 2; i <= N; i++) {
            x = (x.next = new Node(i));
        }
        x.next = header;//头尾相接
        System.out.println("被咔嚓的顺序为：");
        while (x != x.next) {
            //至少还有2人，继续报数
            for (int i = 1; i < M; i++) {
                x = x.next;
            }
            System.out.println(x.next.val + "被咔嚓");
            x.next = x.next.next;
        }
        System.out.println("最后的幸运儿：" + x.val);
    }

    public static void main(String[] args) {
        Josephus josephus = new Josephus();
        josephus.killNode();
    }
}
