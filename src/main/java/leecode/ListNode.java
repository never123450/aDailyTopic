package leecode;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    //链表节点的构造函数
    //使用arr为参数，创建一个链表，当前的listNode为链表头结点
    public ListNode(int arr[]) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty.");
        }

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    //以当前的节点为头结点的链表信息字符串
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            stringBuilder.append(cur.val + "->");
            cur = cur.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }
}