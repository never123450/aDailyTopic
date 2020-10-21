package leecode.linkedList;

import leecode.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 交换链表相邻的元素
 * <p>
 * 练习：25 147
 * @author: xwy
 * @create: 11:14 AM 2020/3/5
 **/

public class Solution24 {

    // 一定要记得画图
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while (p.next != null && p.next.next != null) {

            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            p.next = node2;
            node1.next = next;
            node2.next = node1;

            p = node1;
        }
        return dummyHead.next;

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
        int[] arr = {1, 2, 3, 4};
        Solution24 solution24 = new Solution24();
        ListNode head = solution24.createLinkedList(arr, arr.length);
        solution24.pringLinkedList(head);

        System.out.println();
        ListNode listNode = solution24.swapPairs(head);
        solution24.pringLinkedList(listNode);

    }
}