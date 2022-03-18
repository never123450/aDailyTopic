package leecode.linkedList;

import leecode.ListNode;

/**
 * @description: 合并2个有序的链表
 * @author: xwy
 * @create: 9:52 AM 2020/4/8
 **/

public class Solution21 {

    /*
     递归想不到，不会
     能想到的就是迭代
      */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                pre.next = list2;
                pre = list2;
                list2 = list2.next;
            } else {
                pre.next = list1;
                pre = list1;
                list1 = list1.next;
            }
        }

        // 最后可能会剩下一个链表，把它加在最后面
        if (list1 != null) {
            pre.next = list1;
        }
        if (list2 != null) {
            pre.next = list2;
        }
        return dummyHead.next;
    }

    /**
     * @param
     * @param list1
     * @param list2
     * @return leecode.ListNode
     * @Description 递归
     * @author xwy
     * @date 18/3/2022 上午11:11
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val){
           list2.next =  mergeTwoLists(list2.next,list1);
           return list2;
        }else {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
    }
}