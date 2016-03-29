package caijing.leetcode;

/**
 * Created by Caij on 2016/3/16.
 */
public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        ListNode low = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }

        if (fast != null) low = low.next;

        low = reverse(low);

        while (low != null) {
            if (low.val != head.val) {
                return false;
            }
            low = low.next;
            head = head.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        System.out.println(isPalindrome(node));
    }
}
