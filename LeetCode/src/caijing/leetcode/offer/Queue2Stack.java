package caijing.leetcode.offer;

import java.util.Stack;

/**
 * Created by Caij on 2016/3/2.
 */
public class Queue2Stack {

//    用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }
}
