package caijing.leetcode;

/**
 * Created by Caij on 2016/3/17.
 */
public class RemoveDuplicatesFromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode r =  new ListNode(0);
        r.next = head;
        ListNode pre = r;
        ListNode current = head;

        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }

            if (pre.next == current) {
                pre = current;
            }else {
                pre.next = current.next;
            }

            current = current.next;
        }

        return r.next;
    }

    public static void main(String[] args) {
        deleteDuplicates(new ListNode(1));
    }

}
