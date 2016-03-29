package caijing.leetcode;

/**
 * Created by Caij on 2016/3/14.
 */
public class AddTwoNumbers {

    public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = (l1.val + l2.val) % 10;
        int carry = (l1.val + l2.val) / 10;
        ListNode root = new ListNode(val);
        ListNode current = root;

        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            current.next = new ListNode(val);

            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            current.next = new ListNode(val);

            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            current.next = new ListNode(val);

            current = current.next;
            l2 = l2.next;
        }


        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode node1  = new ListNode(0);

        ListNode node2  = new ListNode(2);
        ListNode node3  = new ListNode(7);
        ListNode node4  = new ListNode(8);
        node2.next = node3;
        node3.next = node4;

        ListNode root  = addTwoNumbers(node1, node2);

        while (root != null) {
            System.out.println(root.val + ",");
            root = root.next;
        }
    }

}
