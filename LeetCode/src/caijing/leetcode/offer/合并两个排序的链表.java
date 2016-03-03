package caijing.leetcode.offer;

/**
 * Created by Caij on 2016/3/3.
 */
public class 合并两个排序的链表 {

//    输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

    public ListNode merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode root = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (root == null) {
                    current = root = list1;
                }else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else {
                if (root == null) {
                    current = root = list2;
                }else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }

        if(list1 == null){
            current.next = list2;
        }
        if(list2 == null){
            current.next = list1;
        }
        return root;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;
        ListNode mergeHead=null;
        if(list1.val<list2.val){
            mergeHead=list1;
            mergeHead.next=Merge(list1.next, list2);
        }
        else{
            mergeHead=list2;
            mergeHead.next=Merge(list1, list2.next);
        }
        return mergeHead;

    }
}
