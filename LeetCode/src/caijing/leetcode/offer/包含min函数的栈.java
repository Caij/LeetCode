package caijing.leetcode.offer;

import java.util.Stack;

/**
 * Created by Caij on 2016/3/3.
 */
public class 包含min函数的栈 {

//    定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

    private int min = -1;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int node) {
        stack.push(node);
        if (node < min) {
            min = node;
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
