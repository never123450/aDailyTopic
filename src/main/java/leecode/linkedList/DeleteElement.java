package leecode.linkedList;


import leecode.ListNode;

public class DeleteElement {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
            return head;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
                prev.next = null;
                return prev.next;
            } else {
                prev = prev.next;
            }
        }

        return null;

    }

    public ListNode removeElementsDummyHead(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        int nums[] = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode listNode = (new DeleteElement()).removeElementsDummyHead(head, 6);
        System.out.println(listNode);
    }

}