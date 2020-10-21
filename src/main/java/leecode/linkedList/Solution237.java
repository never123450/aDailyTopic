package leecode.linkedList;

import leecode.ListNode;

/**
 *
 * @description: https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * 删除一个节点  和203同
 *
 * 练习：19
 * @author: xwy
 *
 * @create: 12:21 PM 2020/3/5
**/

public class Solution237 {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
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
        Solution237 solution237 = new Solution237();
        ListNode head = solution237.createLinkedList(arr, arr.length);
        solution237.pringLinkedList(head);

        System.out.println();
        solution237.deleteNode(new ListNode(3));
        solution237.pringLinkedList(head);

    }
}