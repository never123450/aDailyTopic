package leecode.linkedList;

import leecode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/reorder-list/
 * 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 1->2->3->4->5
 * 1->5->2->4->3
 * @author: xwy
 * @create: 20:35 2020/10/20
 **/

public class Solution143 {
    // 利用数组存链表
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode node = head;
        List<ListNode> list = new ArrayList<ListNode>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (j > i) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    // 找到中点,反转右边,合并
    public void reorderList1(ListNode head) {
        if (head == null) return;
        ListNode mid = getMidNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode t1;
        ListNode t2;
        while (l1 != null && l2 != null) {
            t1 = l1.next;
            t2 = l2.next;
            l1.next = l2;
            l1 = t1;
            l2.next = l1;
            l2 = t2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}