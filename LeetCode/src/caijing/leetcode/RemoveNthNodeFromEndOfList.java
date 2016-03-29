package caijing.leetcode;

/**
 * Created by Caij on 2016/3/16.
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = head;
        ListNode current = head;
        ListNode pre = null;
        for (int i = 0; i < n - 1; i ++) {
           root = root.next;
        }
        while (root.next != null) {
            pre = current;
            current = current.next;
            root = root.next;
        }

        if (pre == null) return head.next; // if n == List size
        pre.next = current.next;
        return head;
    }

}
