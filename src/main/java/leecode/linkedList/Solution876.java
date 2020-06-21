package leecode.linkedList;

/**
 * @description: 返回链表的中间节点
 * @author: xwy
 * @create: 4:22 PM 2020/4/9
 **/

public class Solution876 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    方法一：用数组把节点存起来，然后直接把数组中间的节点拿出来
    时间复杂度：O(n) 空间复杂度：O(n)
     */
    public ListNode middleNode(ListNode head) {
        ListNode[] listNodes = new ListNode[100];
        int i = 0;
        while (head!=null){
            listNodes[i] = head;
            i++;
            head = head.next;
        }
        return listNodes[i/2];
    }

    /*
    方法二：先遍历完一遍链表，得到长度l，再次遍历到n/2直接返回
    时间复杂度：O(n) 空间复杂度：O(1)
     */
    public ListNode middleNode2(ListNode head) {
        int l = 0;
        ListNode headd = head;
        while (head!=null){
            l++;
            head = head.next;
        }
        int n = l/2;
        while (n>0){
            n--;
            headd = headd.next;
        }

        return headd;
    }

    /*
    方法三：使用快慢指针，当快指针走到最后的时候，慢指针刚好在中间，快指针每次走2步，慢指针每次走1步
    时间复杂度：O(n) 空间复杂度：O(1)
     */
    public ListNode middleNode3(ListNode head) {
        ListNode fast  = head.next;
        ListNode slow = head;
        while (fast!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

}