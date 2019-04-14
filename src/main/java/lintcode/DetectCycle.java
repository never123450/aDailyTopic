package lintcode;

/**
 *
 * @description: https://www.lintcode.com/problem/linked-list-cycle-ii/description
 *
 * @author: xwy
 *
 * @create: 2019年04月8日12:20:04
**/

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return  null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;    //遇到null了，说明不存在环
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

}