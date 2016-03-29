package caijing.leetcode;

/**
 * Created by Caij on 2016/3/15.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null)  return l1;
        if (l1 == null) return l2;

        ListNode root;
        ListNode current;
        if (l1.val < l2.val) {
            current = root = new ListNode(l1.val);
            l1 = l1.next;
        }else {
            current = root = new ListNode(l2.val);
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            current.next = node;
            current = current.next;
        }

        while (l1 != null) {
            current.next =  new ListNode(l1.val);
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            current.next =  new ListNode(l2.val);
            current = current.next;
            l2 = l2.next;
        }

        return root;
    }
}
