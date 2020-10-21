package leecode.linkedList;

import leecode.ListNode;

/**
 * @description: 合并2个有序的链表
 * @author: xwy
 * @create: 9:52 AM 2020/4/8
 **/

public class Solution21 {

    /*
     递归想不到，不会
     能想到的就是迭代
      */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }
        }

        // 最后可能会剩下一个链表，把它加在最后面
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return dummyHead.next;
    }
}