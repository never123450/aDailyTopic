package leecode.linkedList;

import leecode.ListNode;

import java.util.HashSet;

/**
 * @description: 环形链表
 * @author: xwy
 * @create: 8:40 AM 2020/4/8
 **/

public class Solution141 {

    /*
     方法一：使用hash表 ，把节点都存入hash表中，如果存在环的话就会有重复的节点
     时间复杂度：O(n)
     空间复杂度：O(n)
      */

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head)) {
                return true;
            }
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }

    /*
      方法二：使用快慢指针，如果不存在环，快指针会先到达尾部；如果存在环，快慢指针一定会相遇
      时间复杂度：O(n)
      空间复杂度：O(1)
      */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || slow == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }

    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}