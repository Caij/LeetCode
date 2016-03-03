package caijing.leetcode.offer;

/**
 * Created by Caij on 2016/3/3.
 */
public class 反转链表 {

//    输入一个链表，反转链表后，输出链表的所有元素。


public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public ListNode reverseList(ListNode head) {
        if (head == null)  return null;
        ListNode pre = null;
        ListNode current = head;
        while (current !=  null) {
            ListNode temp;
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }
}
