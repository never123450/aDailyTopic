package leecode.linkedList;

import leecode.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author: xwy
 * @create: 下午5:29 2021/3/26
 **/

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}

// n=5
// 5*(5-1)/(5-2)+(5-3)-(5-4)*(5-5)