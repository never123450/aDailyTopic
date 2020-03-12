package leecode;

/**
 * @description: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表倒数第N个节点
 * <p>
 * 练习：61  143  234
 * @author: xwy
 * @create: 12:39 PM 2020/3/5
 **/

public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        ListNode next = head;
        int i = 0;
        while (i < n - 1) {
            next = next.next;
            i++;
        }

        while (next != null) {
            cur = cur.next;
            next = next.next;
        }


        // 找到了倒数第N个元素cur，删除cur
        ListNode curNext = cur.next;
        if (curNext == null)
            return null;
        cur.val = curNext.val;
        cur.next = curNext.next;

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 以下 方便测试
    ListNode createLinkedList(int arr[], int n) {
        if (n == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);

        ListNode curNode = head;
        for (int i = 1; i < n; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    void pringLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "-> ");
            cur = cur.next;
        }
        System.out.println("NULL");
    }

    // 元素为2个或者1个的时候错误

    public static void main(String[] args) {
        int[] arr = {1, 2};
        Solution19 Solution19 = new Solution19();
        ListNode head = Solution19.createLinkedList(arr, arr.length);
        Solution19.pringLinkedList(head);

        ListNode listNode = Solution19.removeNthFromEnd(head, 1);
        Solution19.pringLinkedList(listNode);

    }
}