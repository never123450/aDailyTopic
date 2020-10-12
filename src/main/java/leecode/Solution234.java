package leecode;

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
        head.next = null;

        // 找到中间节点
        ListNode mid = middleNode(head);
        // 翻转链表右半部分
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;

        while (rHead != null) {
            if (lHead.val != rHead.val) return false;
            rHead = rHead.next;
            lHead = lHead.next;
        }
        return true;
    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        return null;
    }

    /**
     * 找到中间节点(右半部分链表头节点的前一个节点)
     *
     * @param head
     * @return
     */
    private ListNode middleNode(ListNode head) {
        return null;
    }
}