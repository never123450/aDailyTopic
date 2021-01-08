package leecode.noClassify;

import leecode.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转链表
 * <p>
 * 练习：92 83 86 328 2 445 203
 * @author: xwy
 * @create: 6:39 PM 2020/3/4
 **/

public class Solution206 {


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

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

    void pringLinkedList(ListNode head){
        ListNode cur = head;
        while (cur!=null){
            System.out.print(cur.val+"-> ");
            cur = cur.next;
        }
        System.out.println("NULL");
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Solution206 solution206 = new Solution206();
        ListNode head = solution206.createLinkedList(arr, arr.length);
        solution206.pringLinkedList(head);

        System.out.println();
        ListNode pre = solution206.reverseList(head);
        solution206.pringLinkedList(pre);

    }

}