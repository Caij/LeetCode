package caijing.leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by Caij on 2016/3/17.
 */
public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-k%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode node1  = new ListNode(1);
        ListNode node2  = new ListNode(2);
        ListNode node3  = new ListNode(7);
//        ListNode node4  = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;

        ListNode root  = rotateRight(node1, 2000000000);

        while (root != null) {
            System.out.println(root.val + ",");
            root = root.next;
        }
    }

}
