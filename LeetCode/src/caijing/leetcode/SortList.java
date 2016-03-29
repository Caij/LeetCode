package caijing.leetcode;

/**
 * Created by Caij on 2016/3/17.
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre= slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre != null) pre.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merg(l1, l2);
    }

    private ListNode merg(ListNode left, ListNode right) {
        ListNode root = new ListNode(0);
        ListNode current = root;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            }else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        }

        if (right != null) {
            current.next = right;
        }

        return root.next;
    }

}
