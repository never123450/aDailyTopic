package leecode.linkedList;

import leecode.ListNode;
import xiaomage.set.HashSet;

/**
 * @description: https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 142. 环形链表 II
 * @author: xwy
 * @create: 上午8:14 2022/3/20
 **/

public class Solution142 {
    /**
     * 使用 HashSet 辅助
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode get = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                get = fast;
                slow = head;
                break;
            }
        }

        if (get != null) {
            while (true){
                if (fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }else {
                    return fast;
                }
            }
        }
        return null;
    }
}