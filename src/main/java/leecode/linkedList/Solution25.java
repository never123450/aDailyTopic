package leecode.linkedList;

import leecode.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * K 个一组翻转链表
 * @author: xwy
 * @create: 11:21 PM 2020/4/26
 **/

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end!=null; i++) {
                end = end.next;
            }
            if (end == null) break;

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;// 不断掉的话下面没办法反转 ，因为cur一直不为空
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }


    // 反转链表
    private ListNode reverse(ListNode head) {
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




}