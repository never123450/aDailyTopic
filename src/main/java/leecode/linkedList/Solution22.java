package leecode.linkedList;

import leecode.ListNode;

/**
 * @description:https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/ 剑指 Offer 22. 链表中倒数第k个节点
 * @projectName:dataStructure
 * @see:leecode.linkedList
 * @author:xwy
 * @createTime:24/3/2022 下午9:37
 * @version:1.0
 */
public class Solution22 {
    /**
     * @param
     * @param head
     * @param k
     * @return leecode.ListNode
     * @Description 快慢指针
     * @author xwy
     * @date 24/3/2022 下午9:44
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }

        while (fast != null) {
            fast=fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
