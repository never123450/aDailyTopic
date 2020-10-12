package leecode;

/**
 * @description: https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 移除链表元素 和237同
 *
 * 练习: 21 82
 * @author: xwy
 * @create: 10:25 AM 2020/3/5
 **/

public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while (cur.next != null) {
            if (cur.next.val == val){
                ListNode del = cur.next;
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return header.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 以下 方便测试
    ListNode createLinkedList(int arr[], int n) {
        if (n == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);

        ListNode curNode = head;
        for (int i = 1; i < n; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    void pringLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "-> ");
            cur = cur.next;
        }
        System.out.println("NULL");
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Solution203 solution203 = new Solution203();
        ListNode head = solution203.createLinkedList(arr, arr.length);
        solution203.pringLinkedList(head);

        System.out.println();
        ListNode pre = solution203.removeElements(head, 3);
        solution203.pringLinkedList(pre);

    }
}