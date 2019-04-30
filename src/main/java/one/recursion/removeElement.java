package one.recursion;

import leecode.ListNode;

//使用递归删除链表中的元素
public class removeElement {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode res = removeElements(head.next, val);

        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDeptString(depth);
        System.out.print(depthString);
        System.out.println("call: remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("return :" + head);
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("after remove:" + val + ":" + res);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("return :" + ret);
//        return head.val == val ? head.next : head;
        return ret;
    }

    private String generateDeptString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();

    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 6, 3, 4, 5, 6, 8};
        ListNode head = new ListNode(nums);
        System.out.println(head);

//        ListNode listNode = (new removeElement()).removeElements(head, 6);
//        System.out.println(listNode);


        ListNode listNode = (new removeElement()).removeElements(head, 6, 0);
        System.out.println(listNode);
    }

}