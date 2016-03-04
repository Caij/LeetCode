package caijing.leetcode.offer;

/**
 * Created by Caij on 2016/3/4.
 */
public class 复杂链表的复制 {

//    输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode clone(RandomListNode pHead){
        if (pHead == null) return null;
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode ans = head;
        if (pHead.random != null) {
            head.random = new RandomListNode(pHead.random.label);
        }
        while (pHead.next != null) {
            pHead = pHead.next;
            head.next = new RandomListNode(pHead.label);
            if (pHead.random != null) {
                head.next.random = new RandomListNode(pHead.random.label);
            }
            head = head.next;
        }
        return ans;
    }
}
