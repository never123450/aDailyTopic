package leecode.linkedList;

import leecode.ListNode;

/**
 * @description: 反转链表
 * <p>
 * 从第一个元素开始反转,pre,cur,next,cur.next->pre,pre=cur,cur=next
 * @author: xwy
 * @create: 8:18 AM 2020/4/8
 **/

public class Solution206 {

    public ListNode reverseList(ListNode head) {
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