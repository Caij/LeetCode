package caijing.leetcode;

/**
 * Created by Caij on 2016/3/20.
 */
public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        ListNode root = new ListNode(0);
        ListNode current = head;
        ListNode pre = root;
        ListNode next;
        while (current != null) {
            next = current.next;
            while (pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }
            current.next = pre.next;
            pre.next = current;
            pre = root;
            current = next;
        }

        return root.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        insertionSortList(root);
        while (root != null) {
            System.out.println(root.val + ",");
            root = root.next;
        }
    }

}
