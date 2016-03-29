package caijing.leetcode;

/**
 * Created by Caij on 2016/3/15.
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode ood = head;
            ListNode event = head.next;
            ListNode eventHead = event;

            while (event != null && event.next != null) {
                ood.next = ood.next.next;
                event.next = event.next.next;

                ood = ood.next;
                event = event.next;
            }

            ood.next = eventHead;
        }
        return head;
    }

}
