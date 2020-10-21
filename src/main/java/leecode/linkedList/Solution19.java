package leecode.linkedList;

import leecode.ListNode;

/**
 * @description: 移除倒数第n个节点
 * @author: xwy
 * @create: 3:37 PM 2020/4/9
 **/

public class Solution19 {


    /*
    方法一：先遍历一遍得到链表的长度  第二次遍历的时候就是删除第 L-n+1个元素 l为链表的长度
    需要注意边界 ！！！！！
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = head;
        int l = 0;
        while (cur != null) {
            cur = cur.next;
            l++;
        }
        cur = dummyNode;
        int del = l - n;
        while (del > 0) {
            del--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyNode.next;
    }

    /*
    方法二：先一个指针遍历到第n个位置，后另一个指针也开始遍历，当第一个指针遍历到最后的时候 后面那个指针也遍历到倒数第n个位置了
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode first = dummyNode.next;
        int firstn = n;
        while (firstn > 0) {
            first = first.next;
            firstn--;
        }

        ListNode slow = dummyNode.next;
        while (first != null) {
            first = first.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummyNode.next;

    }

}