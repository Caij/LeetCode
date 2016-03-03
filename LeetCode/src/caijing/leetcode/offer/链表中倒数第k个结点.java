package caijing.leetcode.offer;

/**
 * Created by Caij on 2016/3/3.
 */
public class 链表中倒数第k个结点 {
//    输入一个链表，输出该链表中倒数第k个结点。

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

    public ListNode FindKthToTail(ListNode head,int k) {
        if(k <= 0) return null;
        ListNode root = head;
        for (int i = 0; i < k - 1; i ++) {
            if (head == null) return null;
            head = head.next;
        }
        if (head == null) return null;
        while (head.next != null) {
            head = head.next;
            root = root.next;
        }

        return root;
    }
}
