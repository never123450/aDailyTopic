package leecode.linkedList;

import leecode.ListNode;

import java.util.*;

/**
 * @description: https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 合并K个排序链表
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * @author: xwy
 * @create: 12:04 PM 2020/3/10
 **/

public class Solution23 {

    // 1.暴力  时间复杂度：O(nlogn)   空间复杂度：O(n)
    public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> nums = new ArrayList<>();
        // 先遍历所有链表，把数据到放入一个数组中
        for (ListNode listNode : lists) {
            while (listNode != null) {
                nums.add(listNode.val);
                listNode = listNode.next;
            }
        }

        if (nums.size() == 0)
            return null;
        //排序
        Collections.sort(nums);

        // 再把数据放入一个链表中
        ListNode listNode = new ListNode(nums.get(0));
        ListNode root = listNode;
        for (int i = 1; i < nums.size(); i++) {
            listNode.next = new ListNode(nums.get(i));
            listNode = listNode.next;
        }

        return root;
    }

    // 2.利用优先队列
    public ListNode mergeKLists1(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o1.val) {
                    return 1;
                } else if (o1.val < o1.val) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }

        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) {
                queue.add(p.next);
            }
        }

        return dummy.next;
    }


    // 3.分治
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}