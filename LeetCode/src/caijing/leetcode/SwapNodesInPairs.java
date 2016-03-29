package caijing.leetcode;

/**
 * Created by Caij on 2016/3/17.
 */
public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;
        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode first = current;
            ListNode sec  = current.next;
            pre.next = sec;
            first.next = sec.next;
            sec.next = first;

            pre = first;
            current = first.next;
        }

        return root.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        swapPairs(node1);
    }

}
