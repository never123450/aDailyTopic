package leecode;

/**
 * @description: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 相交链表
 * @author: xwy
 * @create: 21:00 2020/10/12
 **/

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA, curB = headB;

        while (curA != curB) {
            // 2 个链表不想交的时候会死循环
//            curA = (curA.next == null) ? headB : curA.next;
//            curB = (curB.next == null) ? headA : curB.next;

            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;
        }
        return curA;
    }
}