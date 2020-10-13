package leecode;

import one.redBlackTree.Solution;

/**
 * @description: https://leetcode-cn.com/problems/palindrome-linked-list/
 * 回文链表 (不能破坏原链表结构)
 * @author: xwy
 * @create: 22:26 2020/10/12
 **/

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;

        // 找到中间节点
        ListNode mid = middleNode(head);
        // 翻转链表右半部分
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;
        ListNode rOldHead = rHead;

        boolean result = true;
        while (rHead != null) {
            if (lHead.val != rHead.val) {
                result = false;
                break;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }

        // 恢复右半部分
        reverseList(rOldHead);
        return result;
    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    /**
     * 找到中间节点(右半部分链表头节点的前一个节点)
     *
     * @param head
     * @return
     */
    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(1);
        System.out.println(head);

        Solution234 solution234 = new Solution234();
        boolean palindrome = solution234.isPalindrome(head);
        System.out.println(palindrome);
        System.out.println(head);
    }
}