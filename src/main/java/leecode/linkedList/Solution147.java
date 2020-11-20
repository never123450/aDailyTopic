package leecode.linkedList;

import leecode.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/insertion-sort-list/
 * 对链表进行插入排序
 * @author: xwy
 * @create: 15:44 2020/11/20
 **/

public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, cur = head.next;
        while (cur != null) {
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                // 遍历
                ListNode prev = dummyHead;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }
                // 交换
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }
}