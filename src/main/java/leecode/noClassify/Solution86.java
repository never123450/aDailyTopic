package leecode.noClassify;

import leecode.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/partition-list/
 * 分割链表
 * @author: xwy
 * @create: 21:30 2020/10/12
 **/

public class Solution86 {
    public ListNode partition(ListNode head, int x) {

        if (head == null) return null;
        ListNode lHead = new ListNode(0);
        ListNode lTail = lHead;
        ListNode rHead = new ListNode(0);
        ListNode rTail = rHead;
        while (head != null) {
            if (head.val < x) {
                lTail.next = head;
                lTail = head;
            } else {
                rTail.next = head;
                rTail = head;
            }
            head = head.next;
        }
        rTail.next = null;
        lTail.next = rHead.next;
        return lHead.next;
    }
}